// Filter a given array of integers and output only those values that are less than a specified value . 
// The output integers should be in the same sequence as they were in the input. 
// You need to write a function with the recommended method signature for the languages mentioned below.
//  For the rest of the languages, you have to write a complete code.


package problems 

object FilterArr {
    def main(args: Array[String]) = {
    println {f(3, List(5,6,2,8,0, -1))}
    println {f2(3, List(5,6,2,8,0, -1))}
    println {f3(3, List(5,6,2,8,0, -1))}
  }
    def f(delim:Int,arr:List[Int]):List[Int] =  
      for (a <- arr if a < delim) yield a

    def f2(delim:Int,arr:List[Int]):List[Int] = arr match {
      case List() => List()
      case x :: xs if x < delim => x :: f2(delim, xs)
      case x :: xs => f2(delim, xs)
    }

    def f3(delim:Int,arr:List[Int]):List[Int] =
    arr.flatMap(x=>if (x<delim) List(x) else List())
}