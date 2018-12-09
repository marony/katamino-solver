package binbo_kodakusan

sealed trait Title
case class TheSmallSlam() extends Title

case class Level(val category: Char, val level: Int)

case class PentaBoard() {
  val Height = 5

  def solve(title: Title, level: Level): Seq[Seq[PentaMino]] = {
    // Noneだったらバグ
    PentaBoard.Levels
      .find { case (t, l, _) => t == title && l == level }
      .map { case (t, l, m) => _solve(t, l, m)}
        .get
  }

  private def _solve(title: Title, level: Level, minos: Seq[PentaMino]): Seq[Seq[PentaMino]] = {
    val width = level.level

    def __isSolve(minos: Seq[PentaMino]): Boolean = {
      def loop(board: Array[Boolean], minos: Seq[PentaMino]): Boolean = {
        minos match {
          case Nil => true
          case x :: xs => {
            val xx = PentaMino.rotate(x)
            val bs = xx.blocks.map(b => Index(b.x + xx.pos.x, b.y + xx.pos.y))
            // FIXME: mutableすぎ
            var f = true
            for (b <- bs) {
              if (b.x < 0 || b.x >= width || b.y < 0 || b.y >= Height)
                f = false
              else {
                val i = b.x + b.y * width
                val a = board(i)
                if (a)
                  f = false
                else {
                  board(i) = true
                }
              }
            }
            if (f)
              loop(board, xs)
            else
              false
          }
        }
      }

      val board = (for (i <- 0 until width * Height) yield false).toArray
      loop(board, minos)
    }

    def __minos(minos: Seq[PentaMino]): Seq[Seq[PentaMino]] = {
      val _minos = minos match {
        case Nil => Seq(Seq())
        case x :: xs => {
          x.rot match {
            case CantRotate() => {
              for (xss <- __minos(xs)) // TODO: 移動もしないと
                yield x +: xss
            }
            // Degree0, degree90, Degree180, Degree270
            case _ => {
              for (xss <- __minos(xs);
                   rot <- PentaMino.Rotations;
                   px <- 0 until level.level;
                   py <- 0 until Height) // TODO: 盤に収まるやつだけ入れる
                yield PentaMino(x.blocks, Position(px, py), rot) +: xss
            }
          }
        }
      }
      _minos
    }

    def __solve(minos: Seq[PentaMino]): Seq[Seq[PentaMino]] = {
      println(1)
      val ms = __minos(minos)
      println(2)
      val a = ms.find(__isSolve)
      a match {
        case Some(b) => Seq(b)
        case None => Nil
      }
    }

    __solve(minos)
  }
}

object PentaBoard {
  val Levels: Seq[(Title, Level, Seq[PentaMino])] = Seq(
    (TheSmallSlam(), Level('A', 3),
      // 2, 3, 10
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('A', 4),
      // 2, 3, 10, 6
      Seq(PentaMino.Minos(1), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(5))),
  )
}
