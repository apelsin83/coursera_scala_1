

object lect52 {

  def main(args: Array[String]): Unit = {
    val nums = List(4, 2, 34, 2, 43)
    println(mergesort2(nums)((x: Int, y: Int) => x < y))
  }

  def mergesort2[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(mergesort2(fst)(lt), mergesort2(snd)(lt))
    }
  }

  def mergesort1(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(mergesort1(fst), mergesort1(snd))
    }
  }

  def mergesort0(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys
        case x :: xs1 =>
          ys match {
            case Nil => xs
            case y :: ys1 =>
              if (x < y) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }
      }
      val (fst, snd) = xs splitAt n
      merge(mergesort0(fst), mergesort0(snd))
    }
  }

}

