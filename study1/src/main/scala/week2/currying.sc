object currying {


  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if(a>b) 0
      else f(a) + sumF(a+1, b)
    sumF
  }

  def fact(x: Int): Int = if (x==0) 1 else fact(x-1)

  def sumIntegers = sum(x => x)

  def sumCubecs = sum(x => x*x*x)

  def sumFactorials = sum(fact)

// ----------------------------------------
  sumCubecs(1, 10)
  sumFactorials(10, 20)
  sumFactorials(10, 20)

  sum(x => x*x*x)(1, 10)


  // ----------------------------------------

  def _sum(f: Int => Int)(a:Int, b:Int): Int =
    if(a>b) 0 else f(a) + _sum(f)(a+1,b)

  _sum(x => x*x*x)(1, 10)


  def product(f: Int => Int)(a:Int, b:Int): Int = {
      if (a>b) 1
      else f(a) * product(f)(a+1,b)
  }

  product(x=>x*x)(3,4)

  def factorial(x: Int):Int = product(x=>x)(1, x)


  factorial(5)


  def mapReduce(f: Int=>Int, combine: (Int, Int) => Int, zero: Int)(a:Int, b:Int): Int = {
      if (a > b) zero
      else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }
  mapReduce(x=>x*x, (x,y) => x*y, 1)(3,4)

  def _product(f: Int => Int)(a:Int, b:Int): Int =
    mapReduce(f,(x,y) => x*y, 1)(a,b)

  _product(x=>x*x)(3,4)
}