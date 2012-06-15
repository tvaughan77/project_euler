package euler.problem013

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  
  test("Calling carryTens on (55) is (5, 5)") {
    assertEquals(List(5, 5), App.carryTens(List(55)))
  }
  
  test("Calling carryTens on (1, 22, 3) is (3, 2, 3)") {
    assertEquals(List(3, 2, 3), App.carryTens(List(1, 22, 3)))
  }
  
  test("Calling carryTens on (98, 44, 5) is (1, 0, 2, 4, 5)") {
    assertEquals(List(1, 0, 2, 4, 5), App.carryTens(List(98, 44, 5)))
  }
}


