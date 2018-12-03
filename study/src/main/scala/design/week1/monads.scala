object monads {

  def main(args: Array[String]): Unit = {

    // for (y <- for(x <- m; y <- f(x)) yield y
    //   z <- g(y)) yield z

    // for (x <- m;
    //     y <- f(x)
    //     z <- g(y)) yield z

  }

  trait M[T] {
    def flatMap[U](f: T => M[U]): M[U]
  }

 // def unit[T](x: T): M[T]

  /*
  pass by value (expr: => T)

  These operations must satisfy three important properties:

  Associativity: (x flatMap f) flatMap g == x flatMap (y => f(y) flatMap g)
  Left unit: unit(x) flatMap f == f(x)
  Right unit: m flatMap unit == m

  List: unit(x) = List(x)
  Set: unit(x) = Set(x)
  Option: unit(x) = Some(x)
  Generator: unit(x) = single(x)


  Map can be degined for every monad as a combination of flatMap and unit
  m map f == m flatMap (x => unit(f(x))) == m flatMap (f andThen Unit)
  
  Try pattern

  abstract class Try[T] {
    def flatMap[U](f: T => Try[U]): Try[U] = this match {
      case Success(x) => try f(x) catch { case NonFatal(ex) => Failure(ex) }
      case fail: Failure => fail
    }
    
    def map[U](f: T=>U): Try[U] = this match {
      case Success(x) => Try(f(x))
      case fail: Failure => fail
    }
  }

  unit = Try
  
  */
}