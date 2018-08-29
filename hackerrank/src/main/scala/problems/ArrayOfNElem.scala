// Create an array of  integers, where the value of  
// is passed as an argument to the pre-filled function in your editor. 
// This challenge uses a custom checker, so you can create any array 
// of  integers. For example, if , you could return , , 
// or any other array of equal length.
package problems 

object ArrayOfNElem {
    def main(args: Array[String]) = {
    println {f(10)}
  }
    def f(num:Int) : List[Int] = {
        List.range(0, num)
    }

    def f1(num:Int) : List[Int] = {
      return List.fill(num){1}
  } 
}