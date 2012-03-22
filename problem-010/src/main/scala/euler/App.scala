package euler.problem010

import euler.Primes

/**
 * <p>The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.</p>
 * 
 * <p>Find the sum of all the primes below two million.</p>
 */
object App {

  val limit = 2000000
  
  def main(args: Array[String]) {
    val primes = Primes.getPrimesUpTo(limit)
    println("The primes less than " + limit + " are " + primes)
    
    val sum = primes.foldLeft(0L)(_ + _)
    
    println("The sum of primes less than " + limit + " is " + sum)

  }
}

/*
 * Check out this elegant solution from hideshi_o off the project_euler boards
 * 
import scala.collection.mutable.ListBuffer
object P10 {
  def main(args:Array[String]) {
    val lb = ListBuffer[Long]()
    var count = 2L  
    while(count <= 2000000) {
      if(!(lb.exists(count % _ == 0L))) lb += count
      count = count + 1L
    }   
    val sum = lb.toList.foldLeft(0L)(_ + _)
    println(sum)
  }
}

 */
