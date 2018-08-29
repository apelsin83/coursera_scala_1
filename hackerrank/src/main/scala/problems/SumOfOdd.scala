// You are given a list. Return the sum of odd elements from the given list.
// The input and output portions will be handled automatically.
//  You need to write a function with the recommended method signature.
package problems

object SumOfOdd {
  def main(args: Array[String]) = {
    println { f(List(3, 2, 4, 6, 5, 7, 8, 0, 1)) }
    println { f2(List(3, 2, 4, 6, 5, 7, 8, 0, 1)) }
  }

  def f(arr: List[Int]): Int = {
    arr.filter(x => x % 2 != 0).sum
  }

  def f2(arr: List[Int]): Int = arr match {
    case Nil      => 0
    case x :: Nil => if (x % 2 != 0) x else 0
    case x :: xs  => (if (x % 2 != 0) x else 0) + f2(xs)

  }
}
