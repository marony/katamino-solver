package binbo_kodakusan

object Problems {
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
    (TheSmallSlam(), Level('B', 3),
      // 4, 6, 7
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6))),
    (TheSmallSlam(), Level('B', 4),
      // 4, 6, 7, 2
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(1))),
    (TheSmallSlam(), Level('B', 5),
      // 4, 6, 7, 2, 8
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(1), PentaMino.Minos(7))),
    (TheSmallSlam(), Level('B', 6),
      // 4, 6, 7, 2, 8, 3
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(1), PentaMino.Minos(7), PentaMino.Minos(2))),
    (TheSmallSlam(), Level('B', 7),
      // 4, 6, 7, 2, 8, 3, 10
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(1), PentaMino.Minos(7), PentaMino.Minos(2), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('B', 8),
      // 4, 6, 7, 2, 8, 3, 10, 11
      Seq(PentaMino.Minos(3), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(1), PentaMino.Minos(7), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('C', 3),
      // 2, 5, 6
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5))),
    (TheSmallSlam(), Level('C', 4),
      // 2, 5, 6, 3
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(2))),
    (TheSmallSlam(), Level('C', 5),
      // 2, 5, 6, 3, 4
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(2), PentaMino.Minos(3))),
    (TheSmallSlam(), Level('C', 6),
      // 2, 5, 6, 3, 4, 7
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(2), PentaMino.Minos(3), PentaMino.Minos(6))),
    (TheSmallSlam(), Level('C', 7),
      // 2, 5, 6, 3, 4, 7, 8
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(2), PentaMino.Minos(3), PentaMino.Minos(6), PentaMino.Minos(7))),
    (TheSmallSlam(), Level('C', 8),
      // 2, 5, 6, 3, 4, 7, 8, 9
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(2), PentaMino.Minos(3), PentaMino.Minos(6), PentaMino.Minos(7), PentaMino.Minos(8))),
    (TheSmallSlam(), Level('D', 3),
      // 3, 6, 7
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6))),
    (TheSmallSlam(), Level('D', 4),
      // 3, 6, 7, 4
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(3))),
    (TheSmallSlam(), Level('D', 5),
      // 3, 6, 7, 4, 5
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(3), PentaMino.Minos(4))),
    (TheSmallSlam(), Level('D', 6),
      // 3, 6, 7, 4, 5, 9
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(8))),
    (TheSmallSlam(), Level('D', 7),
      // 3, 6, 7, 4, 5, 9, 11
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(8), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('D', 8),
      // 3, 6, 7, 4, 5, 9, 11, 10
      Seq(PentaMino.Minos(2), PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(8), PentaMino.Minos(10), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('E', 3),
      // 2, 4, 5
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4))),
    (TheSmallSlam(), Level('E', 4),
      // 2, 4, 5, 8
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(7))),
    (TheSmallSlam(), Level('E', 5),
      // 2, 4, 5, 8, 7
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(7), PentaMino.Minos(6))),
    (TheSmallSlam(), Level('E', 6),
      // 2, 4, 5, 8, 7, 10
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(7), PentaMino.Minos(6), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('E', 7),
      // 2, 4, 5, 8, 7, 10, 3
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(7), PentaMino.Minos(6), PentaMino.Minos(9), PentaMino.Minos(2))),
    (TheSmallSlam(), Level('E', 8),
      // 2, 4, 5, 8, 7, 10, 3, 11
      Seq(PentaMino.Minos(1), PentaMino.Minos(3), PentaMino.Minos(4), PentaMino.Minos(7), PentaMino.Minos(6), PentaMino.Minos(9), PentaMino.Minos(2), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('F', 3),
      // 6, 7, 9
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8))),
    (TheSmallSlam(), Level('F', 4),
      // 6, 7, 9, 3
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8), PentaMino.Minos(2))),
    (TheSmallSlam(), Level('F', 5),
      // 6, 7, 9, 3, 10
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8), PentaMino.Minos(2), PentaMino.Minos(9))),
    (TheSmallSlam(), Level('F', 6),
      // 6, 7, 9, 3, 10, 4
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(3))),
    (TheSmallSlam(), Level('F', 7),
      // 6, 7, 9, 3, 10, 4, 2
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(3), PentaMino.Minos(1))),
    (TheSmallSlam(), Level('F', 8),
      // 6, 7, 9, 3, 10, 4, 2, 11
      Seq(PentaMino.Minos(5), PentaMino.Minos(6), PentaMino.Minos(8), PentaMino.Minos(2), PentaMino.Minos(9), PentaMino.Minos(3), PentaMino.Minos(1), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('G', 3),
      // 2, 5, 6
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5))),
    (TheSmallSlam(), Level('G', 4),
      // 2, 5, 6, 8
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(7))),
    (TheSmallSlam(), Level('G', 5),
      // 2, 5, 6, 8, 3
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(7), PentaMino.Minos(2))),
    (TheSmallSlam(), Level('G', 6),
      // 2, 5, 6, 8, 3, 11
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(7), PentaMino.Minos(2), PentaMino.Minos(10))),
    (TheSmallSlam(), Level('G', 7),
      // 2, 5, 6, 8, 3, 11, 4
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(7), PentaMino.Minos(2), PentaMino.Minos(10), PentaMino.Minos(3))),
    (TheSmallSlam(), Level('G', 8),
      // 2, 5, 6, 8, 3, 11, 4, 9
      Seq(PentaMino.Minos(1), PentaMino.Minos(4), PentaMino.Minos(5), PentaMino.Minos(7), PentaMino.Minos(2), PentaMino.Minos(10), PentaMino.Minos(3), PentaMino.Minos(8))),
  )
}
