object lect64 {
   val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
   val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
   val fruit = List("apple", "pear", "orange", "pineapple")
// orderBy groupBy

   def main(args: Array[String]): Unit = {

      println(capitalOfCountry("US"))
      println(capitalOfCountry get "US")
      println(capitalOfCountry get "asas")

      println(showCapital("US"))

      println(fruit sortWith (_.length < _.length))
      println(fruit.sorted)

      println(fruit groupBy(_.head))

     val cap1 = capitalOfCountry withDefaultValue "<unknown>"

      println(cap1("asas"))

      println(p1 + p2)
      println(p11 + p22)
      println(p111 + p222)

  }

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital 

    case None => "missing data"
  }


  class Poly(val terms: Map[Int, Double]) {

    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      terms get exp match {
        case Some(coeff1) => exp -> (coeff + coeff1)
        case None => exp -> coeff
      }
    }

    override def toString() = 
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

  class Poly1(val terms0: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue 0.0

    def + (other: Poly1) = new Poly1(terms ++ (other.terms map adjust))

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    override def toString() = 
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  val p11 = new Poly1(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p22 = new Poly1(0 -> 3.0, 3 -> 7.0)

  class Poly3(val terms0: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue 0.0

    def + (other: Poly3) = new Poly3((other.terms foldLeft terms)(addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }


    override def toString() = 
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  val p111 = new Poly3(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p222 = new Poly3(0 -> 3.0, 3 -> 7.0)

}

