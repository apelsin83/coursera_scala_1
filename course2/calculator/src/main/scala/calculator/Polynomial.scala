package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal(Math.pow(b(), 2) - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    val nB = Signal(-1 * b())
    val twoA = Signal(2 * a())
    val sqDelta = Signal(Math.sqrt(delta()))

    Signal {
      if (delta() < 0) Set()
      else {
        Set(
          (nB() + sqDelta()) / twoA(),
          (nB() - sqDelta()) / twoA())
      }
    }
  }
}
