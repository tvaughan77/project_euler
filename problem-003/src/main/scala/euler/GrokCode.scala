package euler

/**
 * My solution over in App.scala just isn't cutting it from a memory perspecive - - the moment you start trying to do anything
 * with a stream it seems like my heap just blows up.
 * 
 * When trying to figure out what's going on, I stumbled on this solution from grokcode, which is a lot more elegant and a 
 * much better algorithm anyway.  I'm going to use this to get an answer and move on to problem 004 to keep up momentum, because
 * I'm getting frustrated trying to debug what's going on with scala streams.
 * 
 * @see http://grokcode.com/75/learning-scala-with-project-euler/
 */
object GrokCode {
  
  /**
   * <p>Comments from grokcode:</p>
   * 
   * <p>This looks a bit complicated, but its not so bad. So the Stream of prime factors stars out with 2 in order to give 
   * a starting place for looking for factors. The while loop then iterates through Longs starting with the last value in 
   * primes. Once a factor is found, that factor is divided out of limit and the new factor (tmp) is returned by the anonymous 
   * function as the next Long in primes. This continues until all the prime factors of limit are found, at which point limit 
   * is 1 and the loop just keeps returning the highest factor that was found.</p>
   * 
   * <p>The next line forces the lazy evaluation for the first 10 factors of primes, and then prints the last factor, which 
   * gives us the answer. 10 was just an arbitrary number large enough to get the factor we were looking for. A more general 
   * solution would take from primes until it got two sequential elements that were the same, and then print that one.</p>
   * 
   * @param number the number to find the largest prime factor for
   * @return the largest prime factor of {@code number}
   */
  def largestPrimeFactor(number: Long): Long = {
    var limit = number
    lazy val primes: Stream[Long] =
      Stream.cons(2,
                  primes.map(x => {var tmp = x
                                   (while ((limit % tmp) != 0 && limit != 1) { tmp=tmp+1 });
                                   limit = limit / tmp;
                                   tmp}))
    primes.take(10).last
  }

}
