package euler.problem014

import euler.LogHelper
import scala.collection.mutable.HashMap

/**
 * <p>The following iterative sequence is defined for the set of positive integers:<br/>
 * 
 * n --> n/2 (n is even)    <br/>
 * n --> 3n + 1 (n is odd)  <br/>
 * </p>
 * 
 * <p>Using the rule above and starting with 13, we generate the following sequence:<br/>
 * 13  40  20  10  5  16  8  4  2  1   <br/>
 * <br/>
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.</p>
 * 
 * <p>Which starting number, under one million, produces the longest chain?</p>
 * <p>NOTE: Once the chain starts the terms are allowed to go above one million.</p>
 */
object App extends LogHelper {
  
  val limit = 1000000
  val cache = new HashMap[Int, List[Int]]

  def main(args: Array[String]) {
    
    var longestChain = 0
    
    for(i <- 1 to limit) {
      try {
        val size = chain(i).size
        if(size > longestChain) {
          info("New longest chain (%d) discovered by running number %d", size, i)
          longestChain = size
        }
      } catch {
        case ex: StackOverflowError => error("StackOverflowError caused by getting chain for " + i)
      }
    }
  }
  
  def chain(x: Int): List[Int] = {
    require(x > 0)
    
    def computeChain(x: Int): List[Int] = {
      if(cache.isDefinedAt(x)) {
        debug("computeChain hit cache for number %d", x)
        cache(x)
      }
      else if(x == 1) 
        List(1)
      else if(x % 2 == 0) 
        x :: computeChain(x / 2)
      else 
        x :: computeChain(3 * x + 1)

    }
    
    debug("Computing chain for %d", x)    
    if(!cache.isDefinedAt(x)) 
      cache(x) = computeChain(x)
    cache(x)
  }
}
