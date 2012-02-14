package euler.problem003

import euler.LogHelper

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
      number = args(0).toInt
    }
    
    info("The largest prime factor of %d is %d", TARGET, largestPrimeFactor(number).getOrElse("No prime factor found!"))
  }
  
  /**
   * @param number the number to find the largest prime factor for
   * @return an option.  Either .get returns the largest prime factor for {@code number} or else there was an error getting the
   * largest prime factor for {@code number}
   */
  def largestPrimeFactor(number: Long): Option[Long] = {
    require(number > 0)
    val primeCandidates = primes((number/2).toLong)
    info("There are %d primes less than the square root of our target number %d", primeCandidates.length, number)
   
    primeCandidates.reverse find (candidate => number % candidate == 0)
  }
  
  /**
   * @param the upper limit of numbers to search for primes to
   * @return a list of all primes less than {@code limit}
   */
  def primes(limit: Long): List[Long] = {
    require(limit > 1)
    info("Computing primes less than or equal to %d", limit)
    sievePrimes(List.empty[Long], List.range(2, limit + 1))
  }
  
  /*
   * I think this implements Euler's sieve since it's modifying the naturalList on each iteration
   */
  def sievePrimes(primeList: List[Long], naturalList: List[Long]): List[Long] = {
    if(naturalList.isEmpty) {
      primeList.reverse
    } else {
      val prime = naturalList.head
      debug("Found prime %d", prime)
      sievePrimes(prime :: primeList, naturalList filter (_ % prime != 0))
    }
  }
}
