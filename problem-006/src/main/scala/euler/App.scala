package euler.problem006

/**
 * <p>The sum of the squares of the first ten natural numbers is,<br/>
 * 1^2 + 2^2 + ... + 10^2 = 385</p>
 * 
 * <p>The square of the sum of the first ten natural numbers is,<br/>
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025</p>
 * 
 * <p>Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is:<br/>
 * 3025  385 = 2640.</p>
 * 
 * <p>Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.</p>
 */
object App {

  def main(args: Array[String]) {
    val NUM = 100
    println("The difference between the squareOfSums(" + NUM + ") and sumOfSquares(" + NUM + ") is " + diff(NUM))
  }
  
  /**
   * @param n the upper bound of natural numbers to find the difference between its square of sums and sum of squares
   * @return the difference between the square of sums of {@code n} and the sum of squares of {@code n}
   */
  def diff(n: Int): Long = {
    squareOfSums(n) - sumOfSquares(n)
  }
  
  /**
   * @param n the upper bound of natural numbers to take a sum of squares of
   * @return the squaring each number from 1..{@code n} (inclusive), this method returns the sum of those squares
   */
  def sumOfSquares(n: Int): Long = {
    sum(List.tabulate(n+1)(x => x * x))  // add 1 to meet the method signature of "<="
  }
  
  /**
   * 
   */
  def squareOfSums(n: Int): Long = {
    val s = sum((1 to n).toList)
    s * s
  }
  
  /**
   * @see programming scala, 2nd edition. Page 326
   * @param xs a list
   * @return the sum of the integers in the list
   */
  def sum(xs: List[Int]): Long = {
    (0 /: xs) (_ + _)   // Uses the fold left operation to start with 0 and then carry it forward summing each subsequent elem.
  }
}
