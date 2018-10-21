object collectionsRecap {
  def main(args: Array[String]): Unit = {
    println("Hi")
  }
//
//  abstract class List[+T] {
//
//    def map[U](f: T => U): List[U] = this match {
//      case x :: xs => f(x) :: xs.map(f)
//      case Nil => Nil
//    }
//
//    def flatMap[U](f: T => List[U]): List[U] = this match {
//      case x :: xs => f(x) ++ xs.flatMap(f)
//      case Nil => Nil
//    }
//
//    def filter(p: T => Boolean): List[T] = this match {
//      case x :: xs =>
//        if(p(x)) x :: xs.filter(p) else xs.filter(p)
//      case Nil => Nil
//    }
//  }

}