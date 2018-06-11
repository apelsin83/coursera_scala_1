import week3.{Cons, Nil}
import week4._

object nth {
  println("sadasd")

    def nth[T](n: Int, xs: week3.List[T]): T =
      if (n == 0) xs.head
      else nth(n-1, xs.tail)


    val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

    def ntho[T](n: Int, xs: week3.List[T]): T =
      if (n == 0) xs.head
      else ntho(n-1, xs.tail)

    nth(2, list)
}