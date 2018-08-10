

object streams {
  def main(args: Array[String]) = {

    println(100)
    println(
      ((1000 to 10000).toStream filter isPrime)(1)
    )
  }

  def isPrime(n: Int) = (2 until n / 2) forall (n % _ != 0)

  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
  Stream(1, 2, 3)
  (1 to 1000).toStream

  def streamRange(lo: Int, hi: Int): Stream[Int] = 
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))

  def listRange(lo: Int, hi: Int): List[Int] = 
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)

  ((1000 to 10000).toStream filter isPrime)(1)

  // x #:: xs == Stream.cons(x, xs)

  trait StreamL[+T] extends Seq[T] {
    def isEmpty: Boolean
    def head: T
    def tail: StreamL[T]
  }

  object StreamL {
    def cons[T](hd: T, tl: => StreamL[T]) = new StreamL[T] {
      def isEmpty = false
      def head = hd
      def tail = tl
    }

    val empty = new StreamL[Nothing] {
      def isEmpty = true
      def head = throw new NoSuchElementException("empty.head")
      def tail = throw new NoSuchElementException("empty.tail")
    }

    // def filter[T](p: T => Boolean): StreamL[T] =
    //   if (isEmpty) this
    //   else if (p(head)) cons(head, tail.filter(p))
    //   else tail.filter(p)
  }
}