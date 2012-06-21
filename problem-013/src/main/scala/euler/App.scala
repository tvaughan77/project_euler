package euler.problem013

import euler.GridOperations
import euler.Numbers
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
    
    val answer = Numbers.carryTens(sum.toList)
    println(answer)
  }
  
}
