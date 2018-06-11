object lect55 {

  def main(args: Array[String]): Unit = {
    val a = List(2, 4, 1, 4, 5)
    val b = List(3, 0, 7, 2, 9)
    println(sum0(a))
    println(sum1(a))
    println(sum2(a))
    println(sum3(a))
    println(concat0(a, b))
    println(mapFun(a, (x: Int) => x * x))
    println(lengthFun(a))
  }

  def sum0(xs: List[Int]): Int = xs match {
    case Nil => 0
    case x :: xs1 => x + sum0(xs1)
  }

  def sum1(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)
  def sum2(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _)
  def sum3(xs: List[Int]): Int = (xs foldLeft 0) (_ + _)


  def concat0[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _) 

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())(f(_) :: _)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (_, x) => x + 1 )

  // abstract class ListEx[T] {
  //   def reduceLeft(op: (T, T) => T): T = this match {
  //     case Nil => throw new Error("Nil.reduceLeft")
  //     case x :: xs => (xs foldLeft x)(op)
  //   }

  //   def foldLeft[U](z: U)(op:(U, T) => U): U = this match {
  //     case Nil => z
  //     case x :: xs => (xs foldLeft op(x, z))(op)
  //   }

  //   def reduceRight(op: (T, T) => T): T = this match {
  //     case Nil => throw new Error("Nil.reduceRight")
  //     case x :: Nil =>
  //     case x :: xs => op(x, xs.reduceRight(op))
  //   }

  //   def foldRight[](z: U)(op:(U, T) => U): U = this match {
  //     case Nil => z
  //     case x :: xs => op(x, (xs foldRight z)(op))
  //   }

  // }

}