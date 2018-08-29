// Given a list, repeat each element in the list  amount of times. The input and output portions will be handled automatically by the grader. You need to write a function with the recommended method signature.

// Input Format

// The first line contains the integer  where  is the number of times you need to repeat the elements.
// The next  lines each contain an integer. These are the  elements in the array.

package problems

object ListRepl {
  def main(args: Array[String]) = {
    println { f(3, List(5, 6, 8, 8, 0)) }
    println { f1(3, List(5, 6, 8, 8, 0)) }
  }
  def f(num: Int, arr: List[Int]): List[Int] =
    arr.flatMap(x => (1 to num).map(_ => x))

  def f1(num: Int, arr: List[Int]): List[Int] =
    arr.flatMap(List.fill(num)(_))

  def mul(num: Int, va: Int): List[Int] = num match {
    case 1 => List(va)
    case _ => List(va) ::: mul(num - 1, va)
  }

  def f3(num: Int, arr: List[Int]): List[Int] = arr match {
    case Nil => List()
    case x :: Nil => mul(num, x)
    case x :: xs  => mul(num, x) ::: f(num, xs)
  }

  def displayResult(arr: List[Int]) =
    println(f3(arr(0).toInt, arr.drop(1)).map(_.toString).mkString("\n"))

  displayResult(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt))

}
