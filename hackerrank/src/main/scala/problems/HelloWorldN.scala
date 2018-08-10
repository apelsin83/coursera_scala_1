package problems

object HelloWorldN {
    def main(args: Array[String]) = {
    f(5)
  }
   def f(n: Int): Unit =
    if (n > 0) {
        println("Hello World")
        f(n-1)
    } 

    def f1(n: Int) = println("Hello World\n" * n)
    def f2(n: Int) = for(i <- 1 to n) println("Hello World")   
}