package example


object Lists {

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
//  def sum(xs: List[Int]): Int = xs.foldLeft(0){(acc, i) => acc + i}
//  def sum(xs: List[Int]): Int = {
//
//  @annotation.tailrec
//  def go(ls: List[Int], acc: Int = 0): Int = ls match {
//    case z::zs => go(zs, acc + z)
//    case _ => acc
//  }
//
//  go(xs)
//}
  def sum(xs: List[Int]): Int = {

    @annotation.tailrec
    def go(ls: List[Int], acc: Int = 0): Int =
      if (ls.isEmpty) acc
      else go(ls.tail, acc + ls.head)

    go(xs)
  }
  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
//    def max(xs: List[Int]): Int = {
//
//      @annotation.tailrec
//      def go(maxEl: Int, ls: List[Int]): Int = ls match {
//        case z::zs => go(maxEl.max(z), zs)
//        case _ => maxEl
//      }
//
//      xs match {
//        case Nil => throw new NoSuchElementException("Empty List")
//        case ls => go(ls.head, ls.tail)
//      }
//    }

def max(xs: List[Int]): Int = {

  @annotation.tailrec
  def go(maxEl: Int, ls: List[Int]): Int =
    if (ls.isEmpty) maxEl
    else go(maxEl.max(ls.head), ls.tail)

  if (xs.isEmpty) throw new NoSuchElementException("Empty List")
  else go(xs.head, xs.tail)
  }
}
