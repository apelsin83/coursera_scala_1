object trd {
  case class Pos(row: Int, col: Int) {
    /** The position obtained by changing the `row` coordinate by `d` */
    def deltaRow(d: Int): Pos = copy(row = row + d)

    /** The position obtained by changing the `col` coordinate by `d` */
    def deltaCol(d: Int): Pos = copy(col = col + d)
  }

  val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

  val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)
  vector(0)(1)
  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
    (pos: Pos) => levelVector(pos.row)(pos.col) != '-'
  }
  type Terrain = Pos => Boolean
  lazy val terrain: Terrain = terrainFunction(vector)
  assert(terrain(Pos(0,0)), "0,0")

  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val row = levelVector.indexWhere(_.indexOf(c) >= 0)
    val col = levelVector(row).indexOf(c)
    Pos(row, col)
  }

}