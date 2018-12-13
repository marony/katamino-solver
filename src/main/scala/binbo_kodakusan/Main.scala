package binbo_kodakusan

/**
  * Closableをusingで使う
  * ローンパターン
  */
object Loan {
  def using[T <: { def close() }](closable: T)(f: => Unit): Unit = {
    f
    closable.close()
  }
}

/**
  * ローンパターンで処理のログを出力
  * @param name
  */
class LoggableFunction(name: String = "") {
  private[this] val start = System.currentTimeMillis()
  println("========== " + name + " ==========")

  override def close(): Unit = println("Elapsed(ms) : " + (System.currentTimeMillis() - start))
}

/**
  * まいんちゃん
  */
object Kanamino extends App {
  val solver = KataminoSolver()
  // 探索する問題の定義
  for (tl <- Seq(
    // The Small Slam
    (TheSmallSlam(), Level('A', 3)),
    (TheSmallSlam(), Level('A', 4)),
    (TheSmallSlam(), Level('A', 5)),
    (TheSmallSlam(), Level('A', 6)),
    (TheSmallSlam(), Level('A', 7)),
    (TheSmallSlam(), Level('A', 8)),
    (TheSmallSlam(), Level('B', 3)),
    (TheSmallSlam(), Level('B', 4)),
    (TheSmallSlam(), Level('B', 5)),
    (TheSmallSlam(), Level('B', 6)),
    (TheSmallSlam(), Level('B', 7)),
    (TheSmallSlam(), Level('B', 8)),
    (TheSmallSlam(), Level('C', 3)),
    (TheSmallSlam(), Level('C', 4)),
    (TheSmallSlam(), Level('C', 5)),
    (TheSmallSlam(), Level('C', 6)),
    (TheSmallSlam(), Level('C', 7)),
    (TheSmallSlam(), Level('C', 8)),
    (TheSmallSlam(), Level('D', 3)),
    (TheSmallSlam(), Level('D', 4)),
    (TheSmallSlam(), Level('D', 5)),
    (TheSmallSlam(), Level('D', 6)),
    (TheSmallSlam(), Level('D', 7)),
    (TheSmallSlam(), Level('D', 8)),
    (TheSmallSlam(), Level('E', 3)),
    (TheSmallSlam(), Level('E', 4)),
    (TheSmallSlam(), Level('E', 5)),
    (TheSmallSlam(), Level('E', 6)),
    (TheSmallSlam(), Level('E', 7)),
    (TheSmallSlam(), Level('E', 8)),
    (TheSmallSlam(), Level('F', 3)),
    (TheSmallSlam(), Level('F', 4)),
    (TheSmallSlam(), Level('F', 5)),
    (TheSmallSlam(), Level('F', 6)),
    (TheSmallSlam(), Level('F', 7)),
    (TheSmallSlam(), Level('F', 8)),
    (TheSmallSlam(), Level('G', 3)),
    (TheSmallSlam(), Level('G', 4)),
    (TheSmallSlam(), Level('G', 5)),
    (TheSmallSlam(), Level('G', 6)),
    (TheSmallSlam(), Level('G', 7)),
    (TheSmallSlam(), Level('G', 8)),
    // The Slam
    (TheSlam(), Level('A', 5)),
    (TheSlam(), Level('A', 6)),
    (TheSlam(), Level('A', 7)),
    (TheSlam(), Level('A', 8)),
    (TheSlam(), Level('A', 9)),
    // The Grand Slam
    (TheGrandSlam(), Level('A', 4)),
    (TheGrandSlam(), Level('A', 5)),
    (TheGrandSlam(), Level('A', 6)),
    (TheGrandSlam(), Level('A', 7)),
    (TheGrandSlam(), Level('A', 8)),
    (TheGrandSlam(), Level('A', 9)),
    (TheGrandSlam(), Level('A', 10)),
    (TheGrandSlam(), Level('A', 11)),
  )) {
    Loan.using(new LoggableFunction(tl.toString())) {
      val as: Seq[Seq[PentaMino]] = solver.solve(tl._1, tl._2)
        .take(1)
      as.foreach(minos => KataminoSolver.printMinos(tl._2.level, minos))
    }
  }
}
