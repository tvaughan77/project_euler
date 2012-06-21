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
  
  
  /**
   * <p>Assumes the input list of numbers corresponds to digits in a number.  So a list like (1, 5, 3) would 
   * be the number one-hundred-fifty-three.  This method searches for numbers greater than 10 in any given 
   * index and "carries the one" into the next 10's place.  For example, an array like (1, 15, 3) actually represents
   * the number 253 because there is 1 x 100, 15 x 10 and 3 x 1.</p>
   * 
   * @param raw a list of numbers
   * @reutrn A List of numbers, none of which is larger than 10, and for which the index of the number represents the
   * 10's place in an actual number.  For example, the List(7, 3, 2, 5) represents the integer 7,325
   */
  def carryTens(raw: List[Int]): List[Int] = {
    
    /**
     * @param xs a list of numbers from least-significant to most-significant
     * @param carry the number of 10's from recursive iteration N-1 to carry forward to iteration N
     * @return the concatenation of all the single-digit values after the carry forward algorithm is done, in order
     * from least-significant to most-significant (i.e. reverse this list to get a real number)
     */
    def carryForward(xs: List[Int], carry: Int): List[Int] = {
      if (xs.isEmpty) {
        if(carry == 0) {
          Nil
        } else {
          val tens = carry / 10
          val digit = carry % 10
          digit :: carryForward(xs, tens)
        }
      } else {
        val number = xs.head + carry
        val tens = number / 10
        val digit = number % 10
        digit :: carryForward(xs.tail, tens)
      }
    }
    
    carryForward(raw.reverse, 0).reverse
  }  
}
