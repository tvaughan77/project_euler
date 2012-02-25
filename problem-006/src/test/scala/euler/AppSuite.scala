package euler.problem006

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The sum of squares from 1..10 is 385") {
    assertEquals(385, App.sumOfSquares(10))
  }
  
  test("The square of sums from 1..10 is 2640") {
    assertEquals(3025, App.squareOfSums(10))
  }
  
  test("The difference between the sumOfSquares and the squareOfSums from 1..10 is 2640") {
    assertEquals(2640, App.diff(10))
  }
}


