package euler.problem002

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("A fibonacci list of numbers less than 0 is (0)") {
    assertEquals(List(0), App.fibonacciList(0))
  }
  
  
  test("A fibonacci list of numbers less than 1 is (1)") {
    assertEquals(List(1), App.fibonacciList(1))
  }
  
  
  test("A fibonacci list of numbers less than 2 is (1, 2)") {
    assertEquals(List(1, 2), App.fibonacciList(2))
  }
  
  
  test("A fibonacci list of numbers less than 20 is (1, 2, 3, 5, 8, 13)") {
    assertEquals(List(1, 2, 3, 5, 8, 13), App.fibonacciList(20))
  }
  
  
  test("A fibonacci list of numbers less than 100 is (1, 2, 3, 5, 8, 13, 21, 34, 55, 89)") {
    assertEquals(List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89), App.fibonacciList(100))
  }
  
  
  test("The sum of even fibonacci numbers less than 20 is (2+8) = 10") {
    assertEquals(10, App.sumEvenFibs(10))
  }
  
  
  test("The sum of even fibonacci numbers less than 100 is (2 + 8 + 34) = 44") {
    assertEquals(44, App.sumEvenFibs(44))
  }
  
}


