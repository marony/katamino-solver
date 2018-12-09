package binbo_kodakusan

object Kanamino extends App {
  val solver = KataminoSolver()
  for (tl <- Seq(
    (TheSmallSlam(), Level('A', 3)),
    (TheSmallSlam(), Level('A', 4)),
    (TheSmallSlam(), Level('A', 5)),
    (TheSmallSlam(), Level('A', 6)),
    (TheSmallSlam(), Level('A', 7)),
    (TheSmallSlam(), Level('A', 8)),
  )) {
    println(tl)
    val as: Seq[Seq[PentaMino]] = solver.solve(tl._1, tl._2)
    println(s"as.length = ${as.length}")
    as.foreach(minos => {
      KataminoSolver.printMinos(tl._2.level, minos)
      println("")
    })
  }
}
