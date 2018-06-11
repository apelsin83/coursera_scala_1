object highorder {

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def fact(x: Int): Int = if (x==0) 1 else fact(x-1)

//  Intro
//  ---------------------------------
  def sumInt(a: Int, b:Int): Int =
    if (a>b) 0 else a + sumInt(a+1, b)

  def sumCube(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCube(a + 1, b)

  def sumFact(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFact(a + 1, b)

//  ---------------------------------

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a>b) 0
    else f(a) + sum(f, a+1, b)

  def sumInts(a: Int, b: Int) = sum(id, a, b)
  def sumCubes(a: Int, b: Int) = sum(cube, a, b)
  def sumFacts(a: Int, b: Int) = sum(fact, a, b)

// ------------------------------------

  def _sumInts(a: Int, b: Int) = sum(x => x, a, b)
  def _sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

// ------------------------------------

  def sum_tail(f: Int => Int, a: Int, b: Int): Int = {

    def loop(a: Int, acc: Int): Int = {
      if(a>b) acc
      else loop(a+1, acc + f(a))
    }

    loop(a, 0)
  }

  sum(x => x, 10, 20)
  sum_tail(x => x, 10, 20)

}