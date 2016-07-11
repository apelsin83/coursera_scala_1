object session {
  1 + 2

  def sqrt(x: Double): Double = {
    def abs(x: Double): Double = if (x < 0) -x else x

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1.0)

  }

  sqrt(4)
  sqrt(2)

  //tail recursive
  def gcd(a: Int, b: Int): Int = {
    if (b==0) a else gcd(b, a % b)
  }
  gcd(142, 168)

  def factorial(n: Int): Int = {
    if (n==0) 1 else n*factorial(n-1)
  }
  factorial(4)

  def fact(n: Int): Int = {

    def loop(acc: Int, n: Int): Int = {
      if (n==0) acc else loop(acc*n, n-1)
    }

    loop(1, n)
  }

  fact(4)

}