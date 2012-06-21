package euler.problem016

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The multiple of List(1, 2, 3) by 2 is List(2, 4, 6)") {
    assertEquals(List(2, 4, 6), App.multiply(List(1, 2, 3), 2))
  }
  
  test("The multiple of List(2, 5, 6) by 2 is List(5, 1, 2)") {
    assertEquals(List(5, 1, 2), App.multiply(List(2, 5, 6), 2))
  }
  
  test("The multiple of List(5, 1, 2) by 2 is List(1, 0, 2, 4)") {
    assertEquals(List(1, 0, 2, 4), App.multiply(List(5, 1, 2), 2))
  }
  
  test("Raising 2^5 is List(3, 2)") {
    assertEquals(List(3, 2), App.pow(2, 5))
  }
  
  test("Raising 3^10 is List(5, 9, 0, 4, 9)") {
    assertEquals(List(5, 9, 0, 4, 9), App.pow(3, 10))
  }
}


