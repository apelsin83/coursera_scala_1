object lect54 {
  def main(args: Array[String]): Unit = {
    val l = List(1,2,-3,4,5)
    println(squareList0(l))
    println(squareList1(l))
    println(posElems0(l))
    println(posElems1(l))

    println(l filter (x => x > 0))

    println(l filterNot (x => x > 0))

    println(l partition (x => x > 0))


    println(l takeWhile (x => x > 0))

    println(l dropWhile (x => x > 0))


    println(l span (x => x > 0))

    println(pack(List("a", "a", "a", "b", "c", "c", "a")))
    println(encode(List("a", "a", "a", "b", "c", "c", "a")))

  }

  // abstract class List[T] {
  //   def map[U](f: T => U): List[U] = this match {
  //     case Nil => this
  //     case x :: xs => f(x) :: xs.map(f)
  //   }

      // def filter(p: T => Boolean): List[T] = this match {
      //   case Nil => this
      //   case y :: ys => if (p(y)) y :: ys.filter(p) else ys.filter(p)
      // }
  // }

  // abstract class List[T] {
  //   def map[U](f: T => U): List[U] = this match {
  //     case Nil => this
  //     case x :: xs => f(x) :: xs.map(f)
  //   }
  // }

  def scaleList0(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList0(ys, factor)
  }

  

  def scaleList1(xs: List[Double], factor: Double) = 
    xs map (x => x * factor)


  def squareList0(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList0(ys)
  }

  def squareList1(xs: List[Int]): List[Int] =
    xs map(x => x*x)


  //Filtering

  def posElems0(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElems0(ys) else posElems0(ys)
  }



  def posElems1(xs: List[Int]): List[Int] = 
    xs filter (x => x > 0)


  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys => 
      val (first, rest) = xs span (z => z == y)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] = 
    pack(xs).map(x=>(x.head, x.length)) 
  //   xs match {
  //   case Nil => Nil
  //   case y :: ys => 
  //     val (first, rest) = xs span (z => z == y)
  //     first :: pack(rest)
  // }

}