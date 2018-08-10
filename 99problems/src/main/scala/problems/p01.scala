package problems

/*

    Find the last element of a list.
    Example:

    scala> last(List(1, 1, 2, 3, 5, 8))
    res0: Int = 8

*/


object p01 {

  def main(args: Array[String]) = {

    println(lastElement(List(('a', 1))))
  }


  def lastElement[T](lst: List[T]) = {
    lst.last
  }

  def lastElement2[T](lst: List[T]): T = lst match {
    case x :: Nil => x
    case _ :: xs => lastElement2(xs)
    case Nil => throw new NoSuchElementException("Empty list")
  }
}