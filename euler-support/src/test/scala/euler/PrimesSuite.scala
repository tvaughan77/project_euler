package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class PrimesSuite extends FunSuite {

  test("There are 5 primes less-than-or-equal to 11.  They are (2, 3, 5, 7, 11)") {
    val primes = Primes.getPrimesUpTo(11)
    assertEquals(5, primes.size)
    assertEquals(2, primes(0))
    assertEquals(3, primes(1))
    assertEquals(5, primes(2))
    assertEquals(7, primes(3))
    assertEquals(11, primes(4))
  }
  
  test("The first 7 primes are (2, 3, 5, 7, 11, 13, 17)") {
    val primes = Primes.getNPrimes(7)
    assertEquals(7, primes.size)
    assertEquals(2, primes(0))
    assertEquals(3, primes(1))
    assertEquals(5, primes(2))
    assertEquals(7, primes(3))
    assertEquals(11, primes(4))
    assertEquals(13, primes(5))
    assertEquals(17, primes(6))
  }
}
