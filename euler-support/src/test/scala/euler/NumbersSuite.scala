package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class NumbersSuite extends FunSuite {

  test("The first prime number is 2") {
    val first5Primes = Numbers.primes().take(5).toArray
    
    assertEquals(2,  first5Primes(0))
    assertEquals(3,  first5Primes(1))
    assertEquals(5,  first5Primes(2))
    assertEquals(7,  first5Primes(3))
    assertEquals(11, first5Primes(4))
  }
  
  test("All primes less-than-or-equal to 10 are {2, 3, 5, 7}") {
    val primesLessThan10 = Numbers.primes(10)
    
    assertEquals(4, primesLessThan10.size)
    assertEquals(2, primesLessThan10(0))
    assertEquals(3, primesLessThan10(1))
    assertEquals(5, primesLessThan10(2))
    assertEquals(7, primesLessThan10(3))
  }
  
  test("isPrime works correctly for a variety of primes") {
    assertTrue(Numbers.isPrime(2))
    assertTrue(Numbers.isPrime(3))
    assertFalse(Numbers.isPrime(4))
    assertTrue(Numbers.isPrime(5))
    assertFalse(Numbers.isPrime(10000000))
  }
  
  test("the Factors of 6 are (1, 2, 3, 6)") {
    val factors = Numbers.factor(6)
    assertEquals(4, factors.size)
    assertEquals(1, factors(0))
    assertEquals(2, factors(1))
    assertEquals(3, factors(2))
    assertEquals(6, factors(3))
  }
  
  test("Trying to factor a negative number throws an exception") {
    intercept[IllegalArgumentException] {
      Numbers.factor(-5)
    }
  }
  
  test("Trying to factor zero throws an exception") {
    intercept[IllegalArgumentException] {
      Numbers.factor(0)
    }
  }
}
