package binbo_kodakusan

import scala.annotation.tailrec

sealed trait Title
case class TheSmallSlam() extends Title

case class Level(val category: Char, val level: Int)

case class PentaBoard() {
  def solve(title: Title, level: Level): Seq[Seq[PentaMino]] = {
    // Noneだったらバグ
    PentaBoard.Levels
      .find { case (t, l, _) => t == title && l == level }
      .map { case (t, l, m) => _solve(t, l, m)}
        .get
  }

  private def _solve(title: Title, level: Level, minos: Seq[PentaMino]): Seq[Seq[PentaMino]] = {
    val width = level.level

    def __addToEach(mino: PentaMino, rs: Seq[Seq[PentaMino]]): Seq[Seq[PentaMino]] = {
      /**
        * ミノが重なっていないか
        * @param mino
        * @param r
        * @return
        */
      def notCross(mino: PentaMino, r: Seq[PentaMino]): Boolean = {
        val is = r.flatMap(m => m.blocks)
        for (b <- mino.blocks) {
          if (is.contains(b))
            return false
        }
        true
      }

      val minos = PentaMino.getAllPattern(width, PentaBoard.Height, mino)
      for (m <- minos;
           r <- rs
           if notCross(m, r))
        yield m +: r
    }

    @tailrec
    def __solve(minos: Seq[PentaMino], rs: Seq[Seq[PentaMino]]): Seq[Seq[PentaMino]] = {
      minos match {
        case Nil => rs
        case x :: xs => {
          __solve(xs, __addToEach(x, rs))
        }
      }
    }

    __solve(minos, Seq(Seq()))
  }
}

object PentaBoard {
  /**
    * 盤の高さ
    */
  val Height = 5

  /**
    * 問題の定義
    */
  val Levels: Seq[(Title, Level, Seq[PentaMino])] = Seq(
    (TheSmallSlam(), Level('A', 3),
      // 2, 3, 10
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('A', 4),
      // 2, 3, 10, 6
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5))),
    (TheSmallSlam(), Level('A', 5),
      // 2, 3, 10, 6, 11
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('A', 6),
      // 2, 3, 10, 6, 11, 8
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5), PentaMino.Minos(10), PentaMino.Minos(7))),
    (TheSmallSlam(), Level('A', 7),
      // 2, 3, 10, 6, 11, 8, 5
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5), PentaMino.Minos(10), PentaMino.Minos(7), PentaMino.Minos(4))),
    (TheSmallSlam(), Level('A', 8),
      // 2, 3, 10, 6, 11, 8, 5, 4
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5), PentaMino.Minos(10), PentaMino.Minos(7), PentaMino.Minos(4), PentaMino.Minos(3))),
  )

  /**
    * 回転・移動済のミノが盤の中に入っているか
    * @param width
    * @param mino
    * @return
    */
  def isInBoard(width: Int, mino: PentaMino): Boolean = {
    mino.blocks.forall(b => b.x >= 0 && b.x < width && b.y >= 0 && b.y < Height)
  }
}
