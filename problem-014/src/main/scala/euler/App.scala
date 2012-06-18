package euler.problem014

import euler.LogHelper
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

/**
 * <p>The following iterative sequence is defined for the set of positive Longegers:<br/>
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

  def main(args: Array[String]) {
    
    var longestChain = 0
    
    for(i <- 1 to limit) {
      val size = chain(i).size
      if(size > longestChain) {
        info("New longest chain (%d) discovered by running number %d", size, i)
        longestChain = size
      }
    }
  }
  
  /**
   * @param x - a number to get a Collatz chain for
   * @return the Collatz chain for the number {@param x}
   */
  def chain(x: Long): List[Long] = {
    require(x > 0)
    
    def computeChain(x: Long): List[Long] = {
      if(x == 1) 
        List(1)
      else if(x % 2 == 0) 
        x :: computeChain(x / 2)
      else 
        x :: computeChain(3 * x + 1)

    }
    
    computeChain(x)
  }
  
  
  
  /**
   * Iterative version of the recursive chain solution
   * (unused - helped me find out I was blowing over the Int limit into negative territory)
   */
  def chain2(x: Long): List[Long] = {
    require(x > 0)
    var num = x
    var chain = new ListBuffer[Long]
    while(num != 1) {
      println("num = " + num + " and chain size is " + chain.size)
      chain += num
      if(num % 2 == 0)
        num = num / 2
      else 
        num = 3 * num + 1
    }
    chain += 1
    chain.toList
  }
}
