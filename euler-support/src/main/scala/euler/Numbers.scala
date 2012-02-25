package euler

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
}