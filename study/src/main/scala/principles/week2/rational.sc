object rational {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.sub(y).sub(z)

  y.add(y)

  x.less(y)

  x.max(y)

  val xx = new RationalEx(1, 3)
  val yy = new RationalEx(5, 7)
  val zz = new RationalEx(3, 2)

  xx.sub(yy).sub(zz)

  yy.add(yy)

  xx.less(yy)

  xx.max(yy)

//  val strange = new Rational(1, 0)




  class Rational(x: Int, y: Int) {
    require(y !=0, "denominator must be non zero")
//    assert(y>0)

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a % b)
//    private val g  = gcd(x,y)
//
//    def numer = x /g
//    def denom = y /g

    val numer = x /gcd(x, y)
    val denom = y /gcd(x, y)


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
    require(y !=0, "denominator must be non zero")
    //    assert(y>0)

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a % b)
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


}

