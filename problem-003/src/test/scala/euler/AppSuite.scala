package euler.problem003

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  
  test("The greatest prime factor of 100 is 5") {
    assertEquals(5, App.largestPrimeFactor(100).get)
  }
  
  test("The greatest prime factor of 121 is 11") {
    assertEquals(11, App.largestPrimeFactor(121).get)
  }
  
  test("The greatest prime factor of 51 is 17") {
    assertEquals(17, App.largestPrimeFactor(51).get)
  }
}


