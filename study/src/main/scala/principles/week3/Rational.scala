package week3

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non zero")
  //    assert(y>0)

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def max(that: Rational) = if (this.less(that)) that else this

  def less(that: Rational) =
    numer * that.denom < that.numer * denom

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  override def toString = numer + "/" + denom

}

class RationalEx(x: Int, y: Int) {
  require(y != 0, "denominator must be non zero")
  //    assert(y>0)

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  //    private val g  = gcd(x,y)
  //
  //    def numer = x /g
  //    def denom = y /g

  val numer = x
  val denom = y

  def max(that: RationalEx) = if (this.less(that)) that else this

  def less(that: RationalEx) =
    numer * that.denom < that.numer * denom

  def add(that: RationalEx) =
    new RationalEx(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def neg: RationalEx = new RationalEx(-numer, denom)

  def sub(that: RationalEx) = add(that.neg)

  override def toString = {
    def g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}
