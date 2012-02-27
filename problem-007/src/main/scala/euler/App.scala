package euler.problem007

import euler.LogHelper
import euler.Numbers
import scala.collection.mutable.ListBuffer

/**
 * <p>By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.</p>
 * <p>What is the 10,001st prime number?</p>
 * 
 * @since 2012/02/27
 */
object App extends LogHelper {
  
  private final val TARGET = 10001

  def main(args: Array[String]) {
    var number = TARGET
    if(args != null && !args.isEmpty && args(0) != null) {
      number = args(0).toInt
    }
    
    println("The " + TARGET + "th prime is " + getNthPrime(TARGET))
  }
  
  /**
   * @param index the "Nth" number prime you're looking for.  For example, getNthPrime(4) would return 7.  {@code index}
   * must be greater than 0 for the funtion call to make any sense.
   * @return The nth prime
   */
  def getNthPrime(index: Long): Long = {
    require(index > 0)
    primes(index).last
  }
  
  /**
   * @param index the number of primes to generate
   * @return a List of all primes from the 1st prime (2) up to the {@code index}th prime.
   */
  def primes(index: Long): List[Long] = {
    require(index > 0)
    
    val primes = new ListBuffer[Long]()
    var i = 2
    while(primes.size != index) {
      if(Numbers.isPrime(i)) {
        info("Found prime %d", i)
        primes += i
      }
      i = i + 1
    }
    primes.toList
  }
}
