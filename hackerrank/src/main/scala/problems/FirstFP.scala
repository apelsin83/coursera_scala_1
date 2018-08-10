package problems

object FirstFP {
  def main(args: Array[String]) = {

    println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)
  }
}