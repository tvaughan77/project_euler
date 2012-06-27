package euler.problem017

import euler.LogHelper
import scala.collection.immutable.HashMap

/**
 * <p>If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there 
 * are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.</p>
 * 
 * <p>If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many
 * letters would be used?</p>
 * 
 * <p>NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 
 * letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out 
 * numbers is in compliance with British usage.</p>
 * 
 * FIXME - runtime is fast for small numbers, but can be improved by caching the numbers as they're spelled out
 * 
 */
object App extends LogHelper {
  
  val numMap = HashMap(0    -> "zero",
                       1    -> "one",
                       2    -> "two",
                       3    -> "three",
                       4    -> "four",
                       5    -> "five",
                       6    -> "six",
                       7    -> "seven",
                       8    -> "eight",
                       9    -> "nine",
                       10   -> "ten",
                       11   -> "eleven",
                       12   -> "twelve",
                       13   -> "thirteen",
                       14   -> "fourteen",
                       15   -> "fifteen",
                       16   -> "sixteen",
                       17   -> "seventeen",
                       18   -> "eighteen",
                       19   -> "nineteen",
                       20   -> "twenty",
                       30   -> "thirty",
                       40   -> "forty",
                       50   -> "fifty",
                       60   -> "sixty",
                       70   -> "seventy",
                       80   -> "eighty",
                       90   -> "ninety")

  def main(args: Array[String]) {
    println("The number of letters it takes to spell the numbers from 1...1000 inclusive is = " + 
            countLettersInNumbers(1, 1000))
  }
  
  /**
   * @param start the number to start counting from
   * @param end the number to end counting on (inclusive)
   * @return the number of letters it takes to spell all the numbers from {@code start} to {@code end}. For example,
   * {@code countLettersInNumber(1, 5)} results in 19 because there are 19 letters in "one two three four five"
   */
  def countLettersInNumbers(start: Int, end: Int): Int = {
    var count = 0
    for(i <- start to end) {
      count = count + countLettersInSpelling(i)
    }
    count
  }
  
  /**
   * @param x a number to count the number of letters is takes to spell
   * @return the number of letters (excluding spaces and hypens) it takes to spell the number {@code x} 
   * For example, {@code countLettersInSpelling(5)} is 4 (because f.i.v.e is a 4 letter word).
   */
  def countLettersInSpelling(x: Int): Int = {
    num2word(x).replace("-", "").replace(" ", "").size
  }
  
  /**
   * Currently only works for numbers between 0 and 1,000 (inclusive)
   * @param x the number to turn in to a word
   * @return the word representing the number (e.g. num2word(77) yields "seventy seven").
   */
  def num2word(x: Int): String = {
    require(x >= 0)
    require(x <= 1000)

    val thousands = (x / 1000) % 10
    val hundreds = (x / 100) % 10
    val under100 = x % 100
      
    if(thousands > 0) {
      val thousandsString = numMap(thousands) + " thousand" 
      if(hundreds > 0) {
        thousandsString + num2word(x % 1000)
      } else {
        thousandsString
      }
    } else if(hundreds > 0) {
      val hundredsString = numMap(hundreds) + " hundred"
      if(under100 > 0) {
        hundredsString + " and " + num2wordUnder100(under100)
      } else {
        hundredsString
      }
    } else {
      num2wordUnder100(x)
    }
  }
  
  
  def num2wordUnder100(x: Int): String = {
    require(x >= 0)
    require(x < 100)
    
    if(numMap.contains(x)) {
      numMap(x)
    } else {
      val tens = ((x / 10) % 10) * 10
      val ones = x % 10
      numMap(tens) + "-" + numMap(ones)
    }
  }
}
