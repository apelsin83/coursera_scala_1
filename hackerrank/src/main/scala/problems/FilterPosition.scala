// For a given list with  integers, return a new 
// list removing the elements at odd positions. 
// The input and output portions will be handled automatically. 
// You need to write a function with the recommended method signature.
package problems 

object FilterPosition {
    def main(args: Array[String]) = {
    println {f(List(5,6,2,8,0, -1))}
  }
    def f(arr:List[Int]):List[Int] = {
      {for (i <- arr.indices if i % 2 == 1)
        yield arr(i)}.toList
    }
}