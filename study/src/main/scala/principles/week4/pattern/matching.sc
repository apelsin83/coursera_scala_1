object matching {

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr

//  object Number {
//    def apply(n: Int)= new Number(n)
//  }
//
//  object Sum {
//    def apply(e1: Expr, e2: Expr)= new Sum(e1, e2)
//  }

  def eval(e: Expr): Int = e match {

    case Number(n) => n

    case Sum(e1: Expr, e2: Expr) => eval(e1) + eval(e2)

  }
  eval(Sum(Number(1), Number(2)))



  trait Expr2 {
    def eval2: Int = this match {
      case Number2(n) => n
      case Sum2(e1, e2) => e1.eval2 + e2.eval2
    }
  }

  def show(e: Expr2): String = e match {
    case Number2(n) => n.toString
    case Sum2(e1, e2) => show(e1) + " + " + show(e2)
  }

  case class Number2(n: Int) extends Expr2
  case class Sum2(e1: Expr2, e2: Expr2) extends Expr2

  show(Sum2(Number2(1), Number2(2)))

}