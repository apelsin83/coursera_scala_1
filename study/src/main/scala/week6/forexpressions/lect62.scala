object lect62 {
  def main(args: Array[String]): Unit = {
    // give positive integer n, findall pairs of positive i and j
    //  with 1<=j<i<n suj that i + j prime
    val n = 5
    println((1 until n) map (i => (1 until i) map (j => (i, j))))

  }
}