package euler.problem005

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("10 is divisible by {1, 2, 5}") {
    assertTrue(App.isDivisibleBy(10, List(1, 2, 5)))
  }
  
  test("10 is not divisible by {1, 2, 3, 5}") {
    assertFalse(App.isDivisibleBy(10, List(1, 2, 3, 5)))
  }
  
  test("The smallest divisible number by all numbers 1..3 is 6") {
    assertEquals(6, App.smallestDivisible(3))
  }
  
  test("The smallest divisible number by all numbers 1..10 is 2520") {
    assertEquals(2520, App.smallestDivisible(10))
  }
}


