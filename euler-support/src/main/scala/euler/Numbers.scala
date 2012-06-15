package euler

import scala.collection.mutable.ListBuffer

/**
 * Helper class dealing with Natural numbers, Primes, etc.
 */
object Numbers {
  
  /**
   * @param n the starting point of the natural numbers
   * @return a stream of all natural numbers from {@code n} to infinity
   */
  def naturals(n: Long): Stream[Long] = Stream.cons(n, naturals(n+1))
  

  /**
   * @see http://en.literateprograms.org/Sieve_of_Eratosthenes_(Scala)
   * @param nums a stream of natural numbers to create a Stream of primes out of
   * @return a stream of primes numbers
   */
  def makePrimeStream(nums: Stream[Long]): Stream[Long] = 
    Stream.cons(nums.head, 
                makePrimeStream((nums tail) filter (_ % nums.head != 0)))
  
  /**
   * @param n the upper bound of the Stream of primes to compute
   * @return a stream of primes numbers from 2..n
   */
  def primes(): Stream[Long] = makePrimeStream(naturals(2))
  
  /**
   * @param limit the highest-valued prime that we're interested in
   * @return a List of all primes less than or equal to {@code limit}
   */
  def primes(limit: Long): Stream[Long] = primes.takeWhile(_ <= limit)
    
  
  /**
   * @param n a number to determine if it is prime
   * @return true, if {@code n} is prime, false otherwise.  Prime numbers are > 1 natrual numbers only divisible by themselves 
   * and 1
   */
  def isPrime(n: Long) = {
    def isp(i:Long): Boolean = 
      if(i==n) 
        true 
    else if(n % i == 0) 
      false 
    else 
      isp(i+1)
    isp(2)
  }
  
  /**
   * TODO - this is brute-force and isn't optimized with any dynamic programming techniques
   * @param n a number to find the factors for
   * @return the list of factors of {@code n}
   */
  def factor(n: Long): List[Long] = {    // note: using a Long here prevents us from doing Ranges and filters (I think)
    require(n > 0)
    val factors = new ListBuffer[Long]
    var i = 1
    while(i <= n) {   // FIXME - only need to go up to n/2 here
      if(n % i == 0)
        factors += i
      i = i + 1
    }
    factors.toList
  }
}
