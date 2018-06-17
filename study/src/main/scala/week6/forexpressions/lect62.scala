object lect62 {
  def main(args: Array[String]): Unit = {
    // give positive integer n, findall pairs of positive i and j
    //  with 1<=j<i<n suj that i + j prime

    def isPrime(n: Int) = (2 until n) forall (n % _ != 0)

    val n = 5
    val xss = (1 until n) map (i => (1 until i) map (j => (i, j)))
    println(xss)
    println(xss.flatten)
    // (xss foldRight Seq[Int]())(_ ++ _)
    val xyy = (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
    println(xyy)

    val xzz = (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))
    println(xzz)


    case class Person(name: String, age: Int)
    val persons = List(Person("d", 3), Person("ad", 33), Person("das", 23))
    // 2 ways
    for (p <- persons if p.age > 20) yield p.name
    persons filter (p => p.age > 20) map (p => p.name)

    println(
        for { 
            i <- 1 until n
            j <- 1 until i
            if isPrime(i+j)
        } yield (i, j)
    )

    def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
      (xs zip ys).map{case (x, y) => x * y}.sum

    def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
      (for ((x, y) <- xs zip ys) yield x * y).sum

  }
}