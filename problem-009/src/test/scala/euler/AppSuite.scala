package euler.problem009

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("3, 4, 5 is a pythagorean triplet") {
    assertTrue(App.isPythagoreanTriplet(3, 4, 5))
  }

  test("3, 4, 6 is not a pythagorean triplet") {
    assertFalse(App.isPythagoreanTriplet(3, 4, 6))
  }
  
  test("The List(3, 4, 5) is a pythagorean triplet") {
    assertTrue(App.isPythagoreanTriplet(List(3, 4, 5)))
  }
  
  test("The terms2 of 4 are [(1, 3), (2, 2), (3, 1)]") {
    val terms = App.terms2(4)
    assertEquals(3, terms.size)
    assertTrue(terms.contains(List(1, 3)))
    assertTrue(terms.contains(List(2, 2)))
    assertTrue(terms.contains(List(3, 1)))
  }
  
  test("The terms3 of 4 are [(1, 1, 2), (1, 2, 1), (2, 1, 1)]") {
    val terms = App.terms3(4)
    assertEquals(3, terms.size)
    assertTrue(terms.contains(List(1, 1, 2)))
    assertTrue(terms.contains(List(1, 2, 1)))
    assertTrue(terms.contains(List(2, 1, 1)))
  }
}


