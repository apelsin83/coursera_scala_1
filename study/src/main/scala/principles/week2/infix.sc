object infix {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x - y  - z

  y + y

  x < y

  x max y



  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be non zero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)


    val numer = x / gcd(x, y)
    val denom = y / gcd(x, y)


    def max(that: Rational) = if (this.<(that)) that else this

    def < (that: Rational) =
      numer * that.denom < that.numer * denom

    def + (that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )

    def unary_- : Rational = new Rational(-numer, denom)

    def - (that: Rational) = this + -that

    override def toString = numer + "/" + denom

  }

}