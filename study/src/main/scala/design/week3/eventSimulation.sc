

object eventSimulation {

  type Action = () => Unit


  class Wire {
    private var sigVal = false
    private var actions: List[Action] = Nil
    /* Returns the current value of the signal transported by the wire. */

    def getSignal: Boolean = sigVal

    /* Modifies the value of the signal transported by the wire. */

    def setSignal(s: Boolean): Unit =
      if (s != sigVal) {
        sigVal = s
        actions foreach (_())
      }

    /* Attaches the specified procedure to the actions of the wire. All of the
      attached actions are executed at each change of the transported signal. */

    def addAction(a: Action): Unit = {
      actions = a :: actions
      a()
    }
  }


  trait Simulation {
    /* The current simulated time */
    def currentTime: Int = curtime

    /* registers in action 'block' to perfrorm after a given delay relative to the current time */

    def afterDelay(delay: Int)(block: => Unit): Unit = {
      val item =  Event(curtime + delay, () => block)
      agenda = insert(agenda, item)
    }
    /* Performs the simulation until there are no actions waiting */

    def run(): Unit = {
      afterDelay(0) {
        println("*** simulation started, time = " + currentTime + " ***")
      }
      loop()
    }

    def loop(): Unit = agenda match {
      case first :: rest =>
        agenda = rest
        curtime = first.time
        first.action()
        loop()
      case Nil =>
    }

    case class Event(time: Int, action: Action)

    private type Agenda = List[Event]

    private var agenda: Agenda = List()

    private var curtime = 0

    private  def insert(ag: List[Event], item: Event): List[Event] = ag match {

      case first :: rest if first.time <= item.time =>
        first :: insert(rest, item)
      case _ =>
        item :: ag
    }

    def probe(name: String, wire: Wire): Unit = {
      def probeAction(): Unit = {
        println(s"$name $currentTime value = ${wire.getSignal}")
      }

      wire addAction probeAction
    }

  }

  trait Parameters {
    def InverterDelay = 2
    def AndGateDelay = 3
    def OrGateDelay = 5

  }


  class Gates() extends Simulation with Parameters {
    def inverter(input: Wire, output: Wire): Unit = {
      def invertAction(): Unit = {
        val inputSig = input.getSignal
        afterDelay(InverterDelay) {output setSignal !inputSig}
      }
      input addAction invertAction
    }

    def andGate(in1: Wire, in2: Wire, output: Wire): Unit = {
      def andAction(): Unit = {
        val in1Sig = in1.getSignal
        val in2Sig = in2.getSignal
        afterDelay(AndGateDelay) {output setSignal (in1Sig & in2Sig)}
      }
      in1 addAction andAction
      in2 addAction andAction
    }

    def orGate(in1: Wire, in2: Wire, output: Wire): Unit = {
      def orAction(): Unit = {
        val in1Sig = in1.getSignal
        val in2Sig = in2.getSignal
        afterDelay(AndGateDelay) {output setSignal (in1Sig | in2Sig)}
      }
      in1 addAction orAction
      in2 addAction orAction
    }

  }

  case class Circuits() extends Gates {

    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit = {
      val d = new Wire
      val e = new Wire
      orGate(a, b, d)
      andGate(a, b, c)
      inverter(c, e)
      andGate(d, e, s)
    }

    def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit = {
      val s = new Wire
      val c1 = new Wire
      val c2 = new Wire
      halfAdder(b, cin, s, c1)
      halfAdder(a, s, sum, c2)
      orGate(c1, c2, cout)
    }
  }


  object sim extends Circuits with Parameters
  val input1, input2, sum, carry = new Wire
//  probe = new Circuits
//  probe("sum", sum)
//  probe("carry", carry)
//
}
