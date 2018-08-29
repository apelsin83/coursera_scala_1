// You are given a list of  elements. Reverse the list without using the reverse function.
// The input and output portions will be handled automatically.
// You need to write a function with the recommended method signature.
package problems

object ReverseList {
  def main(args: Array[String]) = {
    println { f(List(10, 15, 11, 18, 1)) }
    println { f2(List(10, 15, 11, 18, 1)) }
    println { f3(List(10, 15, 11, 18, 1)) }
  }

  def f(arr: List[Int]): List[Int] = {
    def tailreverse(a: List[Int], result: List[Int]): List[Int] = a match {
      case Nil     => result
      case x :: xs => tailreverse(xs, x :: result)
    }
    tailreverse(arr, List())
  }

  def f3(arr:List[Int]):List[Int] = arr match
  {
      case x::Nil => List(x)
      case x::xs => f3(xs) ::: List(x)
  }

  def f2(arr: List[Int]): List[Int] = arr.reverse
}
