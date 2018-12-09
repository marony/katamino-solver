package binbo_kodakusan

case class KataminoSolver() {
  def solve(title: Title, level: Level): Seq[Seq[PentaMino]] = {
    PentaBoard().solve(title, level)
  }
}

object KataminoSolver {
  def printMinos(width: Int, minos: Seq[PentaMino]): Unit = {
    val Height = 5
    val board = (for (i <- 0 until width * Height) yield 0).toArray
    var no = 1
    for (m <- minos) {
      val mino = PentaMino.rotate(m)
      for (b <- mino.blocks.map(b => Index(b.x + mino.pos.x, b.y + mino.pos.y))) {
        if (b.x >= 0 && b.x < width && b.y >= 0 && b.y < Height) {
          board(b.x + b.y * width) = no
        }
      }
      no += 1
    }
    for (y <- 0 until Height) {
      for (x <- 0 until width) {
        print(board(x + y * width))
      }
      println("")
    }
  }
}
