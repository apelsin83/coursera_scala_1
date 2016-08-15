import math.abs

object exercise2_3 {
  //finding fixed points f(x) = x

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) =
    abs((x-y)/x) / x < tolerance
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  fixedPoint(x => 1 + x/2)(1)
  def sqrt(x: Double) = fixedPoint(y => (y + x /y)/2)(1)
  sqrt(2)

}