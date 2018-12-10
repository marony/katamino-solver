package binbo_kodakusan

/**
  * 回転
  */
sealed trait Rotation

/**
  * 回転できない(しても無駄)
  */
case class CantRotate() extends Rotation

/**
  * 回転なし
  */
case class Degree0() extends Rotation

/**
  * 右90度
  */
case class Degree90() extends Rotation

/**
  * 180度
  */
case class Degree180() extends Rotation

/**
  * 右270度
  */
case class Degree270() extends Rotation

/**
  * 回転なし裏
  */
case class RevDegree0() extends Rotation

/**
  * 右90度裏
  */
case class RevDegree90() extends Rotation

/**
  * 180度裏
  */
case class RevDegree180() extends Rotation

/**
  * 右270度裏
  */
case class RevDegree270() extends Rotation

/**
  * ミノの占める座標
  *
  * @param x
  * @param y
  */
case class Index(x: Int, y: Int)

/**
  * ミノの位置
  *
  * @param x
  * @param y
  */
case class Position(x: Int, y: Int)

/**
  * ミノ
  *
  * @param blocks ミノの占める座標
  * @param pos    ミノの位置
  * @param rot    ミノの回転
  */
case class PentaMino(blocks: Seq[Index], pos: Position, rot: Rotation)

object PentaMino {
  /**
    * 全回転の定義
    */
  val Rotations = Seq(Degree0(), Degree90(), Degree180(), Degree270(), RevDegree0(), RevDegree90(), RevDegree180(), RevDegree270())

  /**
    * ミノ(駒)の定義
    */
  val Minos: Seq[PentaMino] = Seq(
    /**
      * 1
      * □□□□□
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(2, 0), Index(3, 0), Index(4, 0)), Position(0, 0), CantRotate()),
    /**
      * 2
      *  □
      *  □
      *  □
      * □□
      */
    PentaMino(Seq(Index(1, 0), Index(1, 1), Index(1, 2), Index(0, 3), Index(1, 3)), Position(0, 0), Degree0()),
    /**
      * 3
      * □□□□
      *   □
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(2, 0), Index(2, 1), Index(3, 0)), Position(0, 0), Degree0()),
    /**
      * 4
      * □□
      *  □□□
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(1, 1), Index(2, 1), Index(3, 1)), Position(0, 0), Degree0()),
    /**
      * 5
      * □
      * □
      * □□□
      */
    PentaMino(Seq(Index(0, 0), Index(0, 1), Index(0, 2), Index(1, 2), Index(1, 3)), Position(0, 0), Degree0()),
    /**
      * 6
      * □□□
      * □□
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(2, 0), Index(0, 1), Index(1, 1)), Position(0, 0), Degree0()),
    /**
      * 7
      * □ □
      * □□□
      */
    PentaMino(Seq(Index(0, 0), Index(2, 0), Index(0, 1), Index(1, 1), Index(2, 1)), Position(0, 0), Degree0()),
    /**
      * 8
      * □□
      *  □
      *  □□
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(1, 1), Index(1, 2), Index(2, 2)), Position(0, 0), Degree0()),
    /**
      * 9
      * □□
      *  □□
      *  □
      */
    PentaMino(Seq(Index(0, 0), Index(1, 0), Index(1, 1), Index(2, 1), Index(1, 2)), Position(0, 0), Degree0()),
    /**
      * 10
      *  □
      *  □
      * □□□
      */
    PentaMino(Seq(Index(1, 0), Index(1, 1), Index(0, 2), Index(1, 2), Index(2, 2)), Position(0, 0), Degree0()),
    /**
      * 11
      *  □□
      * □□
      * □
      */
    PentaMino(Seq(Index(1, 0), Index(2, 0), Index(0, 1), Index(1, 1), Index(0, 2)), Position(0, 0), Degree0()),
    /**
      * 12
      *  □
      * □□□
      *  □
      */
    PentaMino(Seq(Index(1, 0), Index(0, 1), Index(1, 1), Index(2, 1), Index(1, 2)), Position(0, 0), CantRotate()),
  )

  /**
    * PentaMinoの左上座標を(0, 0)に合わせる
    * @param mino
    * @return
    */
  def normalize(mino: PentaMino): PentaMino = {
    val minX = mino.blocks.minBy(m => m.x).x
    val minY = mino.blocks.minBy(m => m.y).y
    PentaMino(mino.blocks.map(b => Index(b.x - minX, b.y - minY)), mino.pos, mino.rot)
  }

  /**
    * PentaMinoをrotの値によって回転する
    * @param mino
    * @return
    */
  def rotate(mino: PentaMino): PentaMino = {
    val maxX = mino.blocks.maxBy(m => m.x).x
    val maxY = mino.blocks.maxBy(m => m.y).y
    val m = mino.rot match {
      case Degree90() =>
        PentaMino(mino.blocks.map(b => Index(maxY - b.y, b.x)), mino.pos, mino.rot)
      case Degree180() =>
        PentaMino(mino.blocks.map(b => Index(maxX- b.x, maxY- b.y)), mino.pos, mino.rot)
      case Degree270() =>
        PentaMino(mino.blocks.map(b => Index(b.y, maxX- b.x)), mino.pos, mino.rot)
      case RevDegree0() =>
        PentaMino(mino.blocks.map(b => Index(maxX - b.x, b.y)), mino.pos, mino.rot)
      case RevDegree90() =>
        PentaMino(mino.blocks.map(b => Index(maxY - b.y, maxX - b.x)), mino.pos, mino.rot)
      case RevDegree180() =>
        PentaMino(mino.blocks.map(b => Index(maxX - (maxX - b.x), maxY- b.y)), mino.pos, mino.rot)
      case RevDegree270() =>
        PentaMino(mino.blocks.map(b => Index(b.y, maxX- (maxX - b.x))), mino.pos, mino.rot)
      case _ => mino
    }
    normalize(m)
  }

  /**
    * PentaMinoをposの値によって移動する
    * @param mino
    * @return
    */
  def move(mino: PentaMino): PentaMino = {
    PentaMino(mino.blocks.map(b => Index(b.x + mino.pos.x, b.y + mino.pos.y)), mino.pos, mino.rot)
  }

  /**
    * 全ての回転・移動パターンを返す
    * @param width
    * @param height
    * @param mino
    * @return
    */
  def getAllPattern(width: Int, height: Int, mino: PentaMino): Seq[PentaMino] = {
    val rotPattern = if (mino.rot == CantRotate()) Seq(Degree0()) else PentaMino.Rotations
    for (x <- 0 until width;
         y <- 0 until height;
         rot <- rotPattern;
         pp = PentaMino(mino.blocks, Position(x, y), rot);
         p = PentaMino.move(PentaMino.rotate(pp));
         if PentaBoard.isInBoard(width, p))
      yield p
  }
}
