/* Update the values of a list with their absolute values. The input and 
output portions will be handled automatically during grading. 
You only need to write a function with the recommended method signature.
*/

package problems

object UpdateList {
  def main(args: Array[String]) = {
    println { f(List(5, -6, 8, -8, 0)) }
    // println { f2(List(5, -6, 8, -8, 0)) }
  }
  def f(arr:List[Int]):List[Int] = arr match {
    case Nil => Nil
    case x :: xs if x < 0 => -x :: f(xs)
    case x :: xs=> x :: f(xs)
  }
}