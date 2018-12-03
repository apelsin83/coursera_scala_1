

object observerPattern {

  trait Subscriber {

    def handler(pub: Publisher)

  }

  trait Publisher {

    private var subscribers: Set[Subscriber] = Set()

    def subscribe(subscriber: Subscriber): Unit =
      subscribers += subscriber

    def unsubscribe(subscriber: Subscriber): Unit =
      subscribers -= subscriber

    def publish(): Unit =
      subscribers.foreach(_.handler(this))
  }

  class BankAccount extends Publisher {
    private var balance = 0
    def currentBalance: Int = balance
    def deposit(amount: Int): Unit =
      if (amount > 0) {
        balance = balance + amount
        publish()
      }
    def withdraw(amount: Int): Unit =
      if (0 < amount && amount <= balance) {
        balance = balance - amount
        publish()
      } else throw new Error("insufficient funds")
  }

  class Consolidator(observed: List[BankAccount]) extends Subscriber {
    private var total: Int = sum()
    private def sum() =
      observed.map(_.currentBalance).sum
    def handler(pub: Publisher): Unit = sum()
    def totalBalance = total
  }

  class Var[T](expr: => T) extends Signal[T](expr) {
    def update(expr: => T): Unit = ???
  }
  object Var {
    def apply[T](expr: => T) = new Var(expr)
  }

  class StackableVariable[T](init: T) {
    private var values: List[T] = List(init)
    def value: T = values.head
    def withValue[R](newValue: T)(op: => R): R = {
      values = newValue :: values
      try op finally values = values.tail
    }
  }

  object NoSignal extends Signal[Nothing](???)

  object Signal {
    val caller = new StackableVariable[Signal[_]](NoSignal)
    def apply[T](expr: => T) = new Signal(expr)
  }

  class Signal[T](expr: => T) {
    import Signal._
    private var myExpr: () => T = _
    private var myValue: T = _
    private var observers: Set[Signal[_]] = Set()
    update(expr)
    protected def update(expr: => T): Unit = {
      myExpr = () => expr
      computeValue()
    }
    protected def computeValue(): Unit = {
      myValue = caller.withValue(this)(myExpr())
    }
    def apply() = {
      observers += caller.value
      assert(!caller.value.observers.contains(this), "cyclic signal definition")
      myValue
    }
  }
}