object lists {

  val fruit = List("a", "b", "c")
  val fruit2 = "a" :: ("b" :: ("c" :: Nil))
  val fruit3 = Nil.::("c").::("b").::("a")
  val empty = List()
  val empty2 = Nil
// head tail isEmpty

  empty.isEmpty
  fruit.tail.head
  fruit.tail

  1 :: 2 :: fruit
  fruit :: Nil
  List(fruit)
  List()
  List(2 :: fruit)


  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if(x <= y) x :: xs else y :: insert(x, ys)
  }

  isort(List(3,2,5,0))
}
