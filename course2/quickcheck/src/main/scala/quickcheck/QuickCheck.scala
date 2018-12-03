package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    v <- Arbitrary.arbitrary[A]
    m <- oneOf(const(empty), genHeap)
  } yield insert(v, m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property(
    "Finding a minimum of the melding of any two heaps should return a minimum of one or the other") =
    forAll { (h1: H, h2: H) =>
      val m1 = if (isEmpty(h1)) 0 else findMin(h1)
      val m2 = if (isEmpty(h2)) 0 else findMin(h2)
      val m = findMin(meld(h1, h2))

      m == m1 || m == m2
    }

  property("If you insert any two elements into an empty heap, finding the minimum of the resulting heap should get the smallest of the two elements back") =
    forAll { (a: Int, b: Int) =>
    val m = findMin(insert(b, insert(a, empty)))
    m == a.min(b)
  }

  property("min of 3 elements") =
    forAll { (a: Int, b: Int, c: Int) =>
      val m = findMin(insert(c, insert(b, insert(a, empty))))
      m == a.min(b.min(c))
    }

  property("empty") = forAll { _: Int =>
    isEmpty(empty)
  }

  property("not empty after insert") = forAll { (h: H, a: Int) =>
    !isEmpty(insert(a, h))
  }

  property("meld 2 heaps minimum") = forAll { (h1: H, h2: H) =>
    val min = findMin(h1) min findMin(h2)
    findMin(meld(h1, h2)) == min
  }

  property("find min of 2 arbitrary heaps") = forAll { (h1: H, h2: H) =>
    val min = findMin(meld(h1, h2))
    isEmpty(h1) || isEmpty(h2) || min == findMin(h1) || min == findMin(h2)
  }

  property("transferring the minimum to another heap") = forAll { (h1: H, h2: H) =>
    def reduce(h: H): List[A] =
      if (!isEmpty(h)) findMin(h) :: reduce(deleteMin(h))
      else Nil
    val melded = meld(h1, h2)
    val transferred = meld(deleteMin(h1), insert(findMin(h1), h2))
    reduce(melded) == reduce(transferred)
  }

  property(
    "If you insert an element into an empty heap, then delete the minimum, the resulting heap should be empty") =
    forAll { a: Int =>
      isEmpty(deleteMin(insert(a, empty)))
    }

  property(
    "Given any heap, you should get a sorted sequence of elements when continually finding and deleting minima") =
    forAll { h: H =>

      def deleteCheck(h: H): List[A] =
        if (!isEmpty(h)) findMin(h) :: deleteCheck(deleteMin(h))
        else Nil

      deleteCheck(h) == deleteCheck(h).sorted
    }
}
