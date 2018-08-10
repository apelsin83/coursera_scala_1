object generatorsRandom {

  def main(args: Array[String]): Unit = {

    test(pairs(lists, lists)) {
      case (xs, ys) => (xs ++ ys).length >= xs.length
    }

  }

  trait Generator[+T] {

    self => // alia for this

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
      // def generate = f(Generator.this.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }

  }

  // Instances
  val integers = new Generator[Int] {
    val rand = new java.util.Random
    def generate = rand.nextInt()
  } 

  // Booleans chain

  val booleans = for (x <- integers) yield x > 0
  val booleans1 = integers map { x => x > 0}
  // val booleans2 = new Generator[Boolean] {
  //   def generate = (x: Int => x > 0)(integers.generate)
  // }
  val booleans3 = new Generator[Boolean] {
    def generate = integers.generate > 0
  }

  // Pairs chain
  def pairs[T, U](t: Generator[T], u: Generator[U]) = for {
    x <- t
    y <- u
  } yield (x, y)

  def pairs1[T, U](t: Generator[T], u: Generator[U]) = t flatMap {
    x => u map { y => (x, y)}
  }
  def pairs2[T, U](t: Generator[T], u: Generator[U]) = t flatMap {
    x => new Generator[(T, U)] {def generate = (x, u.generate)}
  }
  def pairs3[T, U](t: Generator[T], u: Generator[U]) = new Generator[(T, U)] {
    def generate = (new Generator[(T, U)] {
      def generate = (t.generate, u.generate)
    }).generate
  }

  def pairs4[T, U](t: Generator[T], u: Generator[U]) = new Generator[(T, U)] {
    def generate = (t.generate, u.generate)
  }

  // Single chain
  def single[T](x: T): Generator[T] = new Generator[T] {
    def generate = x
  }

  // Examples

  def choose(lo: Int, hi: Int): Generator[Int] = 
    for (x <- integers) yield lo + x % (hi -lo)

  def oneOf[T](xs: T*): Generator[T] = 
    for (idx <- choose(0, xs.length)) yield xs(idx)

  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def emptyLists = single(Nil)

  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail



  def test[T](g: Generator[T], numTimes: Int = 100)
    (test: T => Boolean): Unit = {
      for (i <- 0 until numTimes) {
        val value = g.generate
        assert(test(value), "test failed for value " + value)
      }
    println("passed " + numTimes + " tests")
    }
}










