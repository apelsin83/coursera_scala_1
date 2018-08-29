/* Update the values of a list with their absolute values. The input and 
output portions will be handled automatically during grading. 
You only need to write a function with the recommended method signature.
*/

package problems

object EvaluateEX {
  def main(args: Array[String]) = {
    println { f(20.0000) }
    println { f2(20.0000) }
  }
  def f(x: Double): Double = {
    def calc(n: Int , acc_n: Int, acc_x: Double): Double = n match {
      case y if y > 9 => 1
      case y => {
        println(s"X / Y : $acc_x / $acc_n = ${acc_x / acc_n}" )
        acc_x / acc_n + calc(n + 1, (n+1) * acc_n, x * acc_x) 
      }
    }

    calc(1, 1, x)
  }

  @annotation.tailrec
  def factorial(n: Int, acc: Int): Int = {
      if (n <= 1) acc
      else factorial(n-1, acc*n)
  }
        
  def f2(x: Double): Double = {
      (0 to 9).toList.map{case a => Math.pow(x,a.toDouble)/factorial(a, 1)}.reduce(_+_)
  }
}