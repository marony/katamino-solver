package binbo_kodakusan

import scala.collection.mutable

/**
  * 問題カテゴリ
  */
sealed trait Title

/**
  * The Small Slam
  */
case class TheSmallSlam() extends Title

/**
  * The Slam
  */
case class TheSlam() extends Title

/**
  * レベル
  *
  * @param category
  * @param level
  */
case class Level(val category: Char, val level: Int)

/**
  * 盤面を表す
  */
case class PentaBoard() {
  def solve(title: Title, level: Level): Stream[Seq[PentaMino]] = {
    // Noneだったらバグ
    Problems.Levels
      .find { case (t, l, _) => t == title && l == level }
      .map { case (t, l, m) => _solve(t, l, m)}
        .get
  }

  /**
    * 問題を解く
    *
    * @param title
    * @param level
    * @param minos
    * @return
    */
  private def _solve(title: Title, level: Level, minos: Seq[PentaMino]): Stream[Seq[PentaMino]] = {
    val width = level.level

    implicit val ord = new Ordering[(PentaMino, Seq[PentaMino], Seq[PentaMino])] {
      override def compare(lhs: (PentaMino, Seq[PentaMino], Seq[PentaMino]), rhs: (PentaMino, Seq[PentaMino], Seq[PentaMino])): Int = {
        // 残っている数が多い方優先(幅優先)
        // TODO: 重心か片よっている順にしたい
        rhs._2.length - lhs._2.length
      }
    }
    val queue = new mutable.PriorityQueue[(PentaMino, Seq[PentaMino], Seq[PentaMino])];

    {
      val m :: ms = minos
      val ma = PentaMino.getAllPattern(width, PentaBoard.Height, m)
      val rss = Seq()
      for (_m <- ma) {
        if (PentaBoard.notCross(_m, rss) &&
          PentaBoard.canPut(width, PentaBoard.Height, _m, rss))
          queue.enqueue((_m, ms, rss))
      }
    }

    while (queue.length > 0) {
      val (m, ms, rs) = queue.dequeue()
      val rss = m +: rs
      ms match {
        case _m +: _ms => {
          val ma = PentaMino.getAllPattern(width, PentaBoard.Height, _m)
          for (__m <- ma) {
            if (PentaBoard.notCross(__m, rss) &&
              PentaBoard.canPut(width, PentaBoard.Height, __m, rss))
              queue.enqueue((__m, _ms, rss))
          }
        }
        case _ => return Stream(rss)
      }
    }
    return Stream.empty[Seq[PentaMino]]
  }
}

object PentaBoard {
  /**
    * 盤の高さ
    */
  val Height = 5

  /**
    * 回転・移動済のミノが盤の中に入っているか
    * @param width
    * @param mino
    * @return
    */
  def isInBoard(width: Int, mino: PentaMino): Boolean = {
    mino.blocks.forall(b => b.x >= 0 && b.x < width && b.y >= 0 && b.y < Height)
  }

  /**
    * ミノが重なっていないか
    *
    * @param mino ミノ
    * @param r    ミノたち
    * @return ミノたちとミノの座標が重なっていたらfalse
    */
  def notCross(mino: PentaMino, rs: Seq[PentaMino]): Boolean = {
    !mino.blocks.exists(b => rs.exists(_.blocks.contains(b)))
  }

  /**
    * 置く場所があるか
    * 連続して空いている領域に5の倍数個ではないものがあったらfalse
    * @param mino
    * @return
    */
  def canPut(width: Int, height: Int, mino: PentaMino, rs: Seq[PentaMino]): Boolean = {
    def index(i: Index) = i.y * width + i.x

    def _canPut(board: Array[Int]): Boolean = {
      def loop(x: Int, y: Int, board: Array[Int]): Int = {
        var c = 0
        if (x >= 0 && x < width && y >= 0 && y < height &&
          board(index(Index(x, y))) == 0) {
          c += 1
          board(index(Index(x, y))) = 2
          c += loop(x - 1, y, board)
          c += loop(x, y - 1, board)
          c += loop(x + 1, y, board)
          c += loop(x, y + 1, board)
        }
        c
      }
      for (y <- 0 until height; x <- 0 until width) {
        val c = loop(x, y, board)
        if (c % 5 != 0)
          return false
      }
      true
    }

    val rss = mino +: rs
    val board = Seq.fill(width * height)(0).toArray
    for (m <- rss) {
      m.blocks.foreach(b => board(index(b)) = 1)
    }
    _canPut(board)
  }
}
