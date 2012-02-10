package euler.problem001

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object App {
  
  def main(args: Array[String]) {
    var upperRange = 1000
    if(args != null && !args.isEmpty && args(0) != null) {
      upperRange = args(0).toInt
    }
    
    val sum = sumOfMultiples(upperRange, List(3, 5))
    
    println("The sum of all numbers from 1 to " + upperRange + " is = '" + sum + "'")
  }
  
  /**
   * <p>Finds the sum of all the multiples of {@code multiples} below {@code limit}</p>
   * <p>For example, sumOfMultiples(1000, 3, 5) finds the sum of all the multiples of 3 or 5 below 1000</p>
   * 
   * @param limit - the upper limit of numbers to sum the multiples over
   * @param multiples - a list of multiples to filter the range of numbers from 1..{@limit} by
   * @return the sum of the multiples from 1..{@range}
   */
  def sumOfMultiples(limit: Int, multiples: List[Int]): Int = {
    val range = List.range(1, limit)
    
    var set = scala.collection.mutable.Set.empty[Int]
    
    for(multiple <- multiples) 
      set ++= range filter(_ % multiple == 0)
    
    var sum = 0
    set.foreach(sum += _)
    
    sum
  }
  
}
