package euler.problem003

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("List of primes below 10 is (2, 3, 5, 7)") {
    assertEquals(List(2, 3, 5, 7), App.primes(10))
  }
  
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


