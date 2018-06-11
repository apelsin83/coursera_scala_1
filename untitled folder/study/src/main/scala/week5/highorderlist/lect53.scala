object lect53 {
  def main(args: Array[String]): Unit = {


  }

  def scaleList0(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList0(ys, factor)
  }
}