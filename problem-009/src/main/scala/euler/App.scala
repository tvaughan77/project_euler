package euler.problem009

/**
 * <p>A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,<br/>
 * a^2 + b^2 = c^2
 * </p>
 * <p>For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.</p>
 *
 * <p>There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.</p>
 * 
 * <p>
 * TODO / FIXMEs:<br>
 * It's inefficient to test all tuples for pythagorean-triplet-ness.  For example, (1, 1, 998) is certainly not a triplet<br/>
 * It's also inefficient to test (a, b, c) and (b, a, c)<br/>
 * 
 * </p>
 * 
 * <p>Sigh...looks at this sick solution I found on the boards after submitting mine.  Nice:
 *
 object P9 {
  def main(args:Array[String]) {
    val l = for{
      a <- 1 to 1000
      b <- 1 to 1000
      if a < b 
      c <- 1 to 1000
      if a + b + c == 1000
      if a * a + b * b == c * c 
    } yield (a, b, c)
    println(l)
    val (a, b, c) = l.head
    println(a * b * c)
  }
}
 */
object App {

  def main(args: Array[String]) {
    val triplets = terms3(1000) filter (isPythagoreanTriplet(_))
    println("The triplets in 1000 are = " + triplets)
    
    val products = triplets map (_.product)
    println("The product of the pythagorean triplets for which (a + b + c = 1000) is =" + products)
    
  }
  
  /**
   * @param a A natural number (for the definition where "natural" is > 0)
   * @return a List of all the trios of natural numbers that sum to {@code a}
   * For example, {@code terms3(4)} returns {@code List(List(1, 1, 2), List(1, 2, 1), List(1, 1, 2))}
   */
  def terms3(a: Int): List[List[Int]] = {
    require(a > 0)
    var termsList = new scala.collection.mutable.ListBuffer[List[Int]]
    for(i <- 1 until a) {
      termsList ++= terms2(a - i) map (List(i) ::: _)
    }
    termsList.toList
  }
  
  /**
   * @param a A natural number (for the definition where "natural" is > 0)
   * @return a List of all of the pairs of natural numbers that sum to {@code a}
   * For example, {@code terms2(4)} returns {@code List(List(1, 3), List(2, 2), List(3, 1))}
   */
  def terms2(a: Int): List[List[Int]] = {
    require(a > 0)
    var termsList = new scala.collection.mutable.ListBuffer[List[Int]]
    for(i <- 1 until a) {
      termsList += List(i, a - i)
    }
    termsList.toList
  }
  
  /**
   * Same as {@code isPythagoreanTriplet(a: Int, b: Int, c: Int)}, just in convenient List form
   * @param triplet a list of 3 Natural numbers
   * @return true if the 0th element squared plus the 1st element squared equals the third element squared
   */
  def isPythagoreanTriplet(triplet: List[Int]): Boolean = {
    require(triplet.size == 3)
    isPythagoreanTriplet(triplet(0), triplet(1), triplet(2))
  }
  
  /**
   * @param a A natural number
   * @param b A natural number
   * @param c A natural number
   * @return true, if a*a plus b*b is equal to c*c.  False otherwise
   */
  def isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean = {
    ((a * a) + (b * b)) == (c * c)
  }
}
