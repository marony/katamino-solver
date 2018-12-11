package binbo_kodakusan

/**
  * 問題解くくん
  */
case class KataminoSolver() {
  def solve(title: Title, level: Level): Seq[Seq[PentaMino]] = {
    PentaBoard().solve(title, level)
  }
}

object KataminoSolver {
  /**
    * 盤面を描画
    *
    * @param width
    * @param minos
    */
  def printMinos(width: Int, minos: Seq[PentaMino]): Unit = {
    val Height = 5
    val board = (for (_ <- 0 until width * Height) yield 0).toArray
    minos.zipWithIndex.foreach { case (m, no) =>
      for (b <- m.blocks) {
        if (b.x >= 0 && b.x < width && b.y >= 0 && b.y < Height) {
          board(b.x + b.y * width) = no + 1
        }
      }
    }
    for (y <- 0 until Height) {
      for (x <- 0 until width) {
        print(board(x + y * width))
      }
      println("")
    }
  }
}
