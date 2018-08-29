// Given a list, repeat each element in the list  amount of times. The input and output portions will be handled automatically by the grader. You need to write a function with the recommended method signature.

// Input Format

// The first line contains the integer  where  is the number of times you need to repeat the elements.
// The next  lines each contain an integer. These are the  elements in the array.

package problems

object ListLength {
  def main(args: Array[String]) = {
    println { f(List(5, 6, 8, 8, 0)) }
    println { f2(List(5, 6, 8, 8, 0)) }
  }
  def f(arr:List[Int]): Int = arr match {
    case Nil => 0
    case x :: xs => 1 + f(xs)
  }

  def f2(arr:List[Int]): Int = arr.foldLeft(0)( (acc,_) => acc+1)
}