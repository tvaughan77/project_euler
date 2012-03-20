package euler.problem009

/**
 * <p>A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,<br/>
 * a^2 + b^2 = c^2
 * </p>
 * <p>For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.</p>
 *
 * <p>There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.</p>
 */
object App {

  def main(args: Array[String]) {
    
  }
  
  /**
   * @param a A natural number (for the definition where "natural" is > 0)
   * @return a List of all of the pairs of natural numbers that sum to {@code a}
   * For example, {@code terms2(4)} returns {@code List(List(1, 3), List(2, 2), List(3, 1))}
   */
  def terms2(a: Int): List[List[Int]] = {
    require(a > 0)
    var termsList = new scala.collection.mutable.ListBuffer[List[Int]]
    for(i <- 1 until (a)) {
      termsList += List(i, a - i)
    }
    termsList.toList
  }
  
  def isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean = {
    ((a * a) + (b * b)) == (c * c)
  }
}
