// package week5
import math.Ordering

object lectTest {

  object WeekDay extends Enumeration {
    type WeekDay = Value
    val C = Value("C")
    val F = Value("F")
    val x = Value("x")
    val xx = Value("xx")
    val y = Value("y")
    val yy = Value("yy")
    val z = Value("z")
    val zz = Value("zz")
    def isOrderType(s: String) = values.exists(_.toString == s)
  }

  def main(args: Array[String]): Unit = {
    val inList = true
    check1(1000000000, inList)
    check2(1000000000, inList)
    check3(1000000000, inList)
  }

  def check1(n: Int, inl: Boolean): Unit = {
    val searchTerm = if (inl) "asdad" else "zz"
    val ms = Map("C" -> true, "F" -> true,
      "x" -> true, "xx" -> true,
      "y" -> true, "yy" -> true,
      "z" -> true, "zz" -> true)
    
    val t1 = System.nanoTime
    for (i <- 1 to n) {
      ms contains searchTerm
    }

    println("Map: ", (System.nanoTime - t1) / 1000000000.0)
  }

  def check2(n: Int, inl: Boolean): Unit = {
    val searchTerm = if (inl) "asdad" else "zz"
    val t1 = System.nanoTime
    for (i <- 1 to n) {
      searchTerm match {
        case "C" => true
        case "F" => true
        case "x" => true
        case "xx" => true
        case "y" => true
        case "yy" => true
        case "z" => true
        case "zz" => true
        case _ => false
      }
    }

    println("Case: ", (System.nanoTime - t1) / 1000000000.0)
  }

  def check3(n: Int, inl: Boolean): Unit = {
    val searchTerm = if (inl) "asdad" else "zz"
    val t1 = System.nanoTime
    for (i <- 1 to n) {
      WeekDay.isOrderType(searchTerm)
    }

    println("Enum: ", (System.nanoTime - t1) / 1000000000.0)
  }
}
