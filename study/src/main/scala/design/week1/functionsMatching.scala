// package design.week1

object functionsMatching {
  // Representation Json in Scala

  // class Box[+A] {
  //   def set(x : A) : Box[A] = identity(x)
  // }

  def main(args: Array[String]): Unit = {
    print(show(data))

    val f: String => String = {case "ping" => "pong"}


    // PARTIAL
    val ff: PartialFunction[String, String] = {case "ping" => "pong"}

    ff.isDefinedAt("ping")
    ff.isDefinedAt("p0ng")




  }

  abstract class JSON
  case class JSeq(elems: List[JSON]) extends JSON
  case class JObj(bindings: Map[String, JSON]) extends JSON
  case class JNum(num: Double) extends JSON
  case class JStr(str: String) extends JSON
  case class JBool(b: Boolean) extends JSON
  case class JNull() extends JSON

  val data = JObj(Map(
    "firstName" -> JStr("John"),
    "lastName" -> JStr("Smith"),
    "adress" -> JObj(Map(
      "streetAddress" -> JStr("21 2nd Street"),
      "state" -> JStr("NY"),
      "postalCode" -> JNum(10021))),
    "phoneNumbers" -> JSeq(List(
      JObj(Map(
        "type" -> JStr("home"), "number" -> JStr("212 555-1234"))),
      JObj(Map(
        "type" -> JStr("fax"), "number" -> JStr("646 555-4567")))))))

  def show(json: JSON): String = json match {
    case JSeq(elems) => "[" + (elems map show mkString ", ") +"]"
    case JObj(bindings) => val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + show(value) 
      }
      "{" + (assocs mkString ", ") + "}"
   case JNum(num) => num.toString
   case JStr(str) => '\"' + str + '\"'
   case JBool(b) => b.toString
   case JNull() => "null"
  }

  // type JBinding = (String, JSON)
  //{ case(k, v) => k + ": " +value } is type of JBinding => String
  // type JBinding => String is short of scala.Function[JBinding, String]

  // trait Map[Key, Value] extends (Key => Value)
  // trait Seq[Elem] extends (Int => Elem)
 

}