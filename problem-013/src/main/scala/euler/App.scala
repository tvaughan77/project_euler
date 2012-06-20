package euler.problem013

import euler.GridOperations
import scala.io.Source

/**
 * <p>Work out the first ten digits of the sum of the one-hundred 50-digit numbers stored in numbers.txt</p>
 * 
 * 
 */
object App {
  
  val numberOfNumbers = 100
  val widthOfNumbers = 50

  def main(args: Array[String]) {
    val source = Source.fromInputStream(getClass.getResourceAsStream("numbers.txt"))
    val data = GridOperations.initialize[Int](numberOfNumbers, widthOfNumbers)
    
    var row = 0
    for(line <- source.getLines) {
      data(row) = line.split("").tail map (_.toInt)
      row = row + 1
      println("row " + row + " is '" + line + "'")
    }
    
    val sum = GridOperations.sumGrid[Int](data)
    
    
    GridOperations.printGrid[Int](data)
    println("=======")
    GridOperations.printArray[Int](sum)
    
    val answer = carryTens(sum.toList)
    println(answer)
  }
  
  /**
   * <p>Assumes the input list of numbers corresponds to digits in a number.  So a list like (1, 5, 3) would 
   * be the number one-hundred-fifty-three.  This method searches for numbers greater than 10 in any given 
   * index and "carries the one" into the next 10's place.  For example, an array like (1, 15, 3) actually represents
   * the number 253 because there is 1 x 100, 15 x 10 and 3 x 1.</p>
   * 
   * @param raw a list of numbers
   * @reutrn A List of numbers, none of which is larger than 10, and for which the index of the number represents the
   * 10's place in an actual number.  For example, the List(7, 3, 2, 5) represents the integer 7,325
   */
  def carryTens(raw: List[Int]): List[Int] = {
    
    /**
     * @param xs a list of numbers from least-significant to most-significant
     * @param carry the number of 10's from recursive iteration N-1 to carry forward to iteration N
     * @return the concatenation of all the single-digit values after the carry forward algorithm is done, in order
     * from least-significant to most-significant (i.e. reverse this list to get a real number)
     */
    def carryForward(xs: List[Int], carry: Int): List[Int] = {
      if (xs.isEmpty) {
        if(carry == 0) {
          Nil
        } else {
          val tens = carry / 10
          val digit = carry % 10
          digit :: carryForward(xs, tens)
        }
      } else {
        val number = xs.head + carry
        val tens = number / 10
        val digit = number % 10
        digit :: carryForward(xs.tail, tens)
      }
    }
    
    carryForward(raw.reverse, 0).reverse
    
  }
  
}
