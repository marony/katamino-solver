package binbo_kodakusan

/**
  * まいんちゃん
  */
object Kanamino extends App {
  val solver = KataminoSolver()
  // 探索する問題の定義
  for (tl <- Seq(
    (TheSmallSlam(), Level('A', 3)),
    (TheSmallSlam(), Level('A', 4)),
    (TheSmallSlam(), Level('A', 5)),
    (TheSmallSlam(), Level('A', 6)),
    (TheSmallSlam(), Level('A', 7)),
    (TheSmallSlam(), Level('A', 8)),
  )) {
    val start = methodStart(tl.toString)
    val as: Seq[Seq[PentaMino]] = solver.solve(tl._1, tl._2)
        .take(1)
    as.foreach(minos => {
      KataminoSolver.printMinos(tl._2.level, minos)
      methodEnd(start)
    })
  }

  /**
    * メソッド開始ログ
    *
    * @param methodName
    * @return
    */
  def methodStart(methodName : String) : Long = {
    println("========== " + methodName + " ==========")
    System.currentTimeMillis()
  }

  /**
    * メソッド終了ログ
    *
    * @param start
    * @param answer
    */
  def methodEnd(start : Long) : Unit = {
    println("Elapsed(ms) : " + (System.currentTimeMillis() - start))
  }
}
