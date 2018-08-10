package problems

/*

 Find the last but one element of a list.
Example:

scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5

*/


object p02 {


  def penultimate[T](lst: List[T]): T = lst match {
    case x :: y :: Nil => x
    case x :: y :: xs => penultimate(y :: xs)
    case _ => throw new NoSuchElementException("Empty list")
  }

   def penultimate2[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

   def penultimateNth[A](ls: List[A], n: Int): A =
    if (n < 0) throw new IllegalArgumentException
    else if (ls.length < n) throw new NoSuchElementException
    else ls.takeRight(n).head

    def penultimateNth2[A](ls: List[A], n: Int): A = {

      def penultimateRec[A](lst: List[A], count: Int): A = (lst, count) match {
        case (x :: xs, 0) => x
        case (x :: xs, n) if n > 0 =>  penultimateRec(xs, n - 1)
        case (_, _) => throw new NoSuchElementException
      }

      if (n < 0) throw new IllegalArgumentException
      else penultimateRec(ls, ls.length - n)

    }


  // Here's one approach to a non-builtin solution.
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil              => resultList.head
        case _ :: tail        =>
          lastNthR(count - 1,
                   if (count > 0) resultList else resultList.tail,
                   tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
}

