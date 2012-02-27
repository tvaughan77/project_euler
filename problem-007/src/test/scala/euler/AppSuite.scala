package euler.problem007

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The list of primes up to 10 is (2 3 5 7 11 13 17 19 23 29)") {
    val size = 10
    val primes = App.primes(size)
    assertEquals(size, primes.size)
    assertEquals(2,  primes(0))
    assertEquals(3,  primes(1))
    assertEquals(5,  primes(2))
    assertEquals(7,  primes(3))
    assertEquals(11, primes(4))
    assertEquals(13, primes(5))
    assertEquals(17, primes(6))
    assertEquals(19, primes(7))
    assertEquals(23, primes(8))
    assertEquals(29, primes(9))
  }
  
  test("The 3rd prime is 5") {
    assertEquals(5, App.getNthPrime(3))
  }
  
  test("The 11th prime is 31") {
    assertEquals(31, App.getNthPrime(11))
  }
  
  
}


