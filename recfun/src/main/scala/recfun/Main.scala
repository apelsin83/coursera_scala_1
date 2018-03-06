package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("())(".toList))
//    println(balance(":-)"))
//    println(balance("(if (zero? x) max (/ 1 x))"))
    print(countChange(7,List(1, 2,5)) )
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || r == c) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }

  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def loop(chars: List[Char], numOpenedBraces: Int): Boolean = {
        if (chars.isEmpty) numOpenedBraces == 0
        else if (chars.head.toString == "(") loop(chars.tail, numOpenedBraces + 1)
        else if (chars.head.toString == ")") numOpenedBraces > 0 && loop(chars.tail, numOpenedBraces - 1)
        else loop(chars.tail, numOpenedBraces)
      }

      loop(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      val sortedCoins = coins.sorted

      def loop(n: Int, m: Int): Int = {
        if (n==0) 1
        else if (n < 0 || m < 0) 0
        else loop(n, m - 1) + loop(n - sortedCoins(m), m)
      }

      loop(money, sortedCoins.length - 1)
    }
  }
