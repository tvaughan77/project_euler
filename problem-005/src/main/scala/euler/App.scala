package euler.problem005

/**
 * <p>2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.</p>
 * 
 * <p>What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?</p>
 * 
 * @since 2012/02/25
 */
object App {

  /**
   * NOTE: I know there's a non-programming way to do this with g.c.d.s, but it's cool to understand lazy streams, so I'm 
   * doing this kind of a brute force way.
   */
  def main(args: Array[String]) {
    val NUM = 20
    println("The smalest positive number that is evenly divisible by all of the numbers from 1 to " + NUM + " is = " +
            smallestDivisible(NUM))
  }

  /**
   * @param number The upper range of the numbers to find a smallest divisible number for.  For example, to answer the question 
   * "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?", call this method
   * with number = 20
   * @return the smallest positive number that is evenly divisible by all of the numbers from 1 to {@code number}
   */
  def smallestDivisible(number: Int): Long = {
    val range = (1 to number).toList
    lazy val myStream: Stream[Long] = 
      Stream.cons(1L, 
                  myStream.map(x => {var tmp = x
                                     (while (!isDivisibleBy(tmp, range)) {tmp = tmp+1})
                                     tmp}))
    
    // Take 2 because "1" is always the head
    myStream.take(2).last
  }
  
  /**
   * @param n a number to check for even divisibility by all numers in {@code nums}
   * @param nums a list of numbers to divide into {@code n}
   * @return true, if every number in {@code nums} evenly divides into {@code n}
   */
  def isDivisibleBy(n: Long, nums: List[Int]): Boolean = {
    if(nums.isEmpty) true
    else if(n % nums.head != 0) false
    else isDivisibleBy(n, nums.tail)
  }
  
}
