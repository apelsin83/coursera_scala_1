import scala.annotation.tailrec

object recursion {

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b==0) a else gcd(b, a % b)

  gcd(14, 21)

  def factorial(n: Int): Int =
    if (n==0) 1 else n*factorial(n-1)

  factorial(5)

  def factorial_tail(n: Int): Int =
  {
    def factorial_iter(acc:Int, n: Int): Int =
      if (n==0) acc
      else factorial_iter(acc*n, n-1)

    factorial_iter(1, n)
  }
  factorial_tail(5)
}
