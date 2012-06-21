package euler.problem016

import euler.LogHelper
import euler.Numbers

/**
 * <p>2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.<br/>
 * What is the sum of the digits of the number 2^1000?</p>
 * 
 * Answer is = 1366
 */
object App extends LogHelper {

  def main(args: Array[String]) {
    info("The sum of the digits in the number 2^1000 is %d", pow(2, 1000).sum)
  }
  
  /**
   * @param base the number to raise to an {@code exponent}
   * @param exponent the number to raise the {@code base} by
   * @return the {@code base^exponent} value, represented as a List, where the head of the list is the
   * most significant digit of the answer and the tail of the List is the one's place
   */
  def pow(base: Int, exponent: Int): List[Int] = {
    var number = List(1)
    for(i <- 1 to exponent) {
      number = multiply(number, base)
      debug("%d^%d is = %s", base, i, number)
    }
    number
  }
  
  /**
   * @param num a number, represented by a List where the head of the list is the most significant figure of
   * the number and the tail is the 1's place of the number.  Assumes base10
   * @param by the number to multiply {@code num} by
   * @return a new list that contains the result of multiplying {@code num} by {@code by}
   */
  def multiply(value: List[Int], by: Int): List[Int] = {
    Numbers.carryTens(value map (_ * by))
  }
}
