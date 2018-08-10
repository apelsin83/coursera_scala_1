object lect61 {
  def main(args: Array[String]): Unit = {

// Iterable => seq => (String, Range, Array, List, Vector, IndexdSeq)
// Iterable => set
// Iterable => hash

// Seq operations exists, forall, zip, unzip, flatMap, sum, product, max, min

    val a = Vector(2, 4, 1, 4, 5)
    val s = "Hello WOrld"
    val r: Range = 1 until 5
    val r1: Range = 1 to 5
    val r2: Range = 1 to 15 by 3


 
    println(10 +: a)
    println(a :+ 10)
    println(a map (x => x * 2))
    println( s filter (c => c.isUpper))
    println(r)
    println(r1)
    println(r2)
    println(s exists (c => c.isUpper))
    println(s forall (c => c.isUpper))

    val pairs = List(1,2,3) zip s
    println(pairs)
    println(pairs.unzip)

    println(s flatMap (c => List('.', c)))

    val M = 3
    val N = 2
    // all pairs
    println((1 to M) flatMap (x => 1 to N map (y => (x, y))))

    // sum product

    def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
      (xs zip ys).map(xy => xy._1 * xy._2).sum

    def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
      (xs zip ys).map{case (x, y) => x * y}.sum

    def isPrime(n: Int): Boolean = 
      (2 until n / 2).map { x => if (n % x == 0) 1 else 0 }.sum == 0

     def isPrime1(n: Int): Boolean = 
      (2 until n ) forall { x => n % x != 0 }

    println(isPrime(6))
    println(isPrime1(6))
  }
}