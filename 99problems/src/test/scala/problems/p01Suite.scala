import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import problems.p01._

@RunWith(classOf[JUnitRunner])
class p01Suite extends FunSuite  {
  test("1 element") {
    assert(lastElement(List('a')) === 'a')
    assert(lastElement2(List('a')) === 'a')
  }

  test("multi element") {
    assert(lastElement(List('a', 'b', 'c')) === 'c')
    assert(lastElement2(List('a', 'b', 'c')) === 'c')
  }

  test("no element") {
    intercept[NoSuchElementException] {
      lastElement(List())
    }
    intercept[NoSuchElementException] {
      lastElement2(List())
    }
  }


}