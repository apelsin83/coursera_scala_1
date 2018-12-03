object generatorsRandom_start {

  def main(args: Array[String]): Unit = {


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


//  val booleans = for(x <- integers) yield x > 0
  val pairs = new Generator1[(Int, Int)] {
    def generate = (integers1.generate, integers1.generate) 
  }


  trait Generator1[+T] {
    def generate: T
  }

  val integers1 = new Generator1[Int] {
    val rand = new java.util.Random
    def generate = rand.nextInt()
  }

  val booleans1 = new Generator1[Boolean] {
    def generate = integers1.generate > 0
  }

  val pairs1 = new Generator1[(Int, Int)] {
    def generate = (integers1.generate, integers1.generate) 
  }
}