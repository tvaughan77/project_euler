package euler.problem012

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The 1st triangle number is 1") {
    assertEquals(1, App.triangle(1))
  }


  test("The 2nd triangle number is 3") {
    assertEquals(3, App.triangle(2))
  }  


  test("The 3rd triangle number is 6") {
    assertEquals(6, App.triangle(3))
  }


  test("The 4th triangle number is 10") {
    assertEquals(10, App.triangle(4))
  }
  
  test("The 10th triangle number is 55") {
    assertEquals(55, App.triangle(10))
    assertEquals(45, App.triangle(9))   // this should be pre-cached because of our call to triangle(10)
  }
}



