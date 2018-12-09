package binbo_kodakusan

object Kanamino extends App {
  val solver = KataminoSolver()
  for (tl <- Seq(
    (TheSmallSlam(), Level('A', 3)),
    (TheSmallSlam(), Level('A', 4)),
  )) {
    println(tl)
    val as: Seq[Seq[PentaMino]] = solver.solve(tl._1, tl._2)
    as.foreach(minos => {
      println(s"as.length = ${as.length}")
      KataminoSolver.printMinos(tl._2.level, minos)
    })
  }
}
