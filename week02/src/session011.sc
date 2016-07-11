object session011 {


  def sum(f: Int => Int, a: Int, b: Int) = {

    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a+1, f(a) + acc)
    }

    loop(a, 0)

  }

  def sumInts(a: Int, b: Int) = sum(x => x, a, b)

  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

  sumInts(1, 5)
  sumCubes(1, 5)
}