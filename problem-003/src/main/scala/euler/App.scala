package euler.problem003

import euler.LogHelper
import euler.Numbers
import euler.GrokCode
import scala.annotation.tailrec

/**
 * <h1>Problem Statement</h1>
 * <p>The prime factors of 13195 are 5, 7, 13 and 29.</p>
 * <p>What is the largest prime factor of the number 600851475143 ?</p>
 * 
 * <h1>Design notes</h1>
 * <p>First thing that pops in to my head is a brute-force approach:<br/>
 * <ul>
 * <li> using Euler's sieve to get all the primes less than our target number**</li>
 * <li> starting at the largest prime I find, work backwards seeing if each prime divides into our target number</li>
 * </ul>
 * </p>
 * 
 * <p>** actually, I think just the primes less than half of our target number will suffice-- I don't think it's possible
 * for a prime factor to exist that is greater than 1/2 of the target number because 2 is a prime, right?</p>
 * 
 * @since 2012/02/11
 * 
 */
object App extends LogHelper {
  private final val TARGET = 600851475143L
  
  def main(args: Array[String]) {
    var number = TARGET
    if(args != null && !args.isEmpty && args(0) != null) {
      number = args(0).toLong
    }
    
    //info("The largest prime factor of %d is %d", TARGET, largestPrimeFactor(number).getOrElse("No prime factor found!"))
    
    //info("The largest prime factor of %d is %d", TARGET, GrokCode.largestPrimeFactor(number))
    
    info("The largest prime factor of %d is %d", TARGET, (largestPrimeFactors(number) max))
  }
  
  
  /**
   * After submitting the GrokCode solution to project eueler, I found this solution on the 7th page of problem discussion that
   * I really like 
   * @author mdufresne
   */
  def largestPrimeFactors(number: Long): List[Long] = {
    def lpf(i: Long, V: Long): List[Long] = {
      if (i >= V) List(V) 
      else if (V % i == 0 && Numbers.isPrime(i)) 
        i :: lpf(i, V / i) 
      else lpf(i + 1, V)
    }
    
    lpf(2, number)
  }

  /**
   *
   * FIXME: This doesn't work for numbers larger than a couple thousand -- something to do with streams blowing up heap ??
   *
   * @param number the number to find the largest prime factor for
   * @return an option.  Either .get returns the largest prime factor for {@code number} or else there was an error getting the
   * largest prime factor for {@code number}
   */
  def largestPrimeFactor(number: Long): Option[Long] = {
    require(number >= 2)
    val upperBound = (number/2).toLong + 1
    
    // Get all primes less than our upper bound
    val primes = Numbers.primes(upperBound)
    info("There are %d primes less than half of our target number (%d / 2 = %d)", primes.size, number, upperBound)
    
    // Starting at the highest value prime, find the first prime that evenly divides our number
    primes.reverse find (candidate => number % candidate == 0)
  }
     

}
