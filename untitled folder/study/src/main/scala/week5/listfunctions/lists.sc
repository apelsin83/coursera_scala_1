

object lists {
  val xs = List(1, 2, 4, 3, 2)
  val yss = List(10, 20, 40, 30, 20)
  xs.length
  xs.head
  xs.tail
  xs.last
  xs.init
  xs take 3
  xs drop 3
  xs(3)

  xs ++ yss
  xs.reverse
  xs updated (3, 8)
  xs indexOf 3
  xs contains 12


  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("Last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("Init of empty list")
    case List(_) => List()
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ::: List(y)
  }

  def removeAt[T](n: Int, xs: List[T]) =
    (xs take n) ::: (xs drop n + 1)

  def flatten(xs: List[Any]): List[Any] = ???


}