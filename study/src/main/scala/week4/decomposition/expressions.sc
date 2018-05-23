object expressions {

  trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr

  }

  class Number(n: Int) extends Expr {
    def isNumber = true

    def isSum = false

    def numValue = n

    def leftOp = throw new Error("Number.leftOp")

    def rightOp = throw new Error("Number.rightOp")
  }

  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber = false

    def isSum = true

    def numValue = throw new Error("Sum.numValue")

    def leftOp = e1

    def rightOp = e2
  }

  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

  def eval2(e: Expr): Int = {
    if (e.isInstanceOf[Number])
      e.asInstanceOf[Number].numValue
    else if (e.isInstanceOf[Sum])
      eval2(e.asInstanceOf[Sum].leftOp) +
        eval2(e.asInstanceOf[Sum].rightOp)
    else throw new Error("Unknown expression " + e)
  }


}