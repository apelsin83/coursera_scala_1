object translationfor {

  def main(args: Array[String]) = {

    val q1 = books flatMap (b =>
      b.authors withFilter (a => a startsWith "Bird") map (y => y.title))
    println(q1)
  }

  // translate map fltMap filter into for functions

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    for (x <- xs) yield f(x)

  def flatMapFun[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
    for (x <- xs; y <- f(x)) yield y

  def filterFun[T](xs: List[T], p: T => Boolean): List[T] =
    for (x <- xs if p(x)) yield x


  case class Book(title: String, authors: List[String])
  val books: Set[Book] = Set(
    Book(title = "Structure and Interpretation of Computer Programs", authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java", authors = List("Bloch, Joshua")),
    Book(title = "Effective Java2", authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers", authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala", authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))

  // Translation by compilator
  // for (x <- e1) yield e2
  // e1.map(x => e2)

  // for (x <- e1 if f; s) yield e2
  // for (x <- e1.withFilter(x=>f); s) yield e2
  // 
  // for (x <- e1; y <- e2; s) yield e3
  // e1.flatMap(x => for (y <- e2; s) yield e3)
  // 


  /*
  * 
  ********************
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrine(i+j)
  } yield (i, j)
  ********************
  (1 until n) flatMap(i =>
    (1 until i).withFilter(j => isPrime(i + j))
    .map(j => (i, j))
  )
  ********************
  */

}