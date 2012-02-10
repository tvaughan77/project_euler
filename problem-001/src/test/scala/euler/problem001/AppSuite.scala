package euler.problem001

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {
  
  test("The sum of multiples of 1 below 3 is 1+2 = 3") {
    assertEquals(3, App.sumOfMultiples(3, List(1)))
  }
  
  test("The sum of multiples of 2 below 7 is 2+4+6 = 12") {
    assertEquals(12, App.sumOfMultiples(7, List(2)))
  }
  
  test("The sum of multiples of 3 and 5 below 10 is 3+5+6+9 = 23") {
    assertEquals(23, App.sumOfMultiples(10, List(3, 5)))
  }
}
