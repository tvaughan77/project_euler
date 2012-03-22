package euler

import scala.collection.mutable.ListBuffer
import scala.util.control._


/**
 * The "Numbers" class ended up being a pain in the ass because of the Streams that always blew heap after a couple thousand
 * primes, so here's my attempt to build some straight-up prime number sequence generators for purposes of just caching/hard
 * coding the sequence of primes up to some number of primes.
 */
object Primes {
  
  def getPrimesUpTo(limit: Long): List[Long] = {
    var primes = ListBuffer.empty[Long]
    primes += 2

    var nextPrime = 3L    
    while(nextPrime <= limit) {
      primes += nextPrime
      nextPrime = getNextPrime(primes)
    }
    
    primes.toList
  }
  
  /**
   * @param limit the limit of the number of primes to fetch
   * @return a List of size {@code limit} of primes, from lowest (i.e. 2) up to the {@code limit}th prime
   */
  def getNPrimes(limit: Int): List[Long] = {
    var primes = ListBuffer.empty[Long]
    primes += 2
    var numPrimes = 1
    
    var nextPrime = 3L
    while(numPrimes < limit) {
      primes += nextPrime
      nextPrime = getNextPrime(primes)
      numPrimes = numPrimes + 1
    }
    
    primes.toList
  }
  


  
  /*
   * Adapted for scala, but from "pgSimple3"
   * @see http://en.wikibooks.org/wiki/Efficient_Prime_Number_Generating_Algorithms
   */
  private def getNextPrime(primes: ListBuffer[Long]): Long = {
    // implicit assumption that input list has been seeded with at least (2, 3)
    var potentialPrime = primes.last + 2
      
    var foundPrime = false
    while(!foundPrime) {
      
      var isPrime = true
      val potentialPrimeSqrt = Math.sqrt(potentialPrime)
      
      val loop = new Breaks
      loop.breakable {
        for(prime <- primes) {
          if(prime > potentialPrimeSqrt) {
            loop.break
          }
          if(potentialPrime % prime == 0) {
            isPrime = false
            loop.break
          }
        }
      }
      if(isPrime) {
        foundPrime = true
      } else {
        potentialPrime = potentialPrime + 2
      }
    }
    potentialPrime
  }
  
}
