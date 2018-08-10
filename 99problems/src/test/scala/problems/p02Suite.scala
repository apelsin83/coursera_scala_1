import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import problems.p02._

@RunWith(classOf[JUnitRunner])
class p02Suite extends FunSuite  {
  test("1 element") {
    intercept[NoSuchElementException] {
      penultimate(List('a'))
    }

    intercept[NoSuchElementException] {
      penultimate2(List('a'))
    }


    intercept[NoSuchElementException] {
      penultimateNth(List('a'), 4)
    }
    intercept[IllegalArgumentException] {
      penultimateNth(List('a'), -4)
    }
    assert(penultimateNth(List('a'), 1) === 'a')

    intercept[NoSuchElementException] {
      penultimateNth2(List('a'), 4)
    }
    intercept[IllegalArgumentException] {
      penultimateNth2(List('a'), -4)
    }
    assert(penultimateNth2(List('a'), 1) === 'a')

  }

  test("multi element") {
    assert(penultimate(List('a', 'b', 'c')) === 'b')
    assert(penultimate2(List('a', 'b', 'c')) === 'b')
    assert(penultimateNth(List('a', 'b', 'c'), 2) === 'b')
    assert(penultimateNth2(List('a', 'b', 'c'), 2) === 'b')

  }

  test("no element") {
    intercept[NoSuchElementException] {
      penultimate(List())
    }
    intercept[NoSuchElementException] {
      penultimate2(List())
    }
    intercept[NoSuchElementException] {
      penultimateNth(List(), 4)
    }
    intercept[NoSuchElementException] {
      penultimateNth2(List(), 4)
    }
  }


}