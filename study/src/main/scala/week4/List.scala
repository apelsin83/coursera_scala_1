package week4

trait List[T] {

  def isEmpty: Boolean
  def head: T
  def tail: List[T]

}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil head")

  override def tail: Nothing = throw new NoSuchElementException("Nil tail")

}