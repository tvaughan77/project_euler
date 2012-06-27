package euler.problem018

import scala.io.Source
import euler.LogHelper
import euler.GridOperations

/**
 * <p>By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
 * the maximum total from top to bottom is 23.<br/>
 * <pre>
 *      3
 *     7 4
 *    2 4 6
 *   8 5 9 3
 * </pre>  
 * That is, 3 + 7 + 4 + 9 = 23.</p>
 * 
 * <p>Find the maximum total from top to bottom of the triangle in our source file</p>
 * 
 * <p>NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 *  However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it 
 *  cannot be solved by brute force, and requires a clever method! ;o)</p>
 */
object App extends LogHelper {
  
  private val GRID_SIZE = 15

  def main(args: Array[String]) {
    val source = Source.fromInputStream(getClass.getResourceAsStream("triangle.txt"))
    val grid = GridOperations.parseDataGrid(source, GRID_SIZE, GRID_SIZE)
    println("The greatest path is : " + greatestPath(grid))
  }
  
  /**
   * @param grid a 2D array containing a triangle of integers (padded by zeroes to the right) 
   * @return the greatest sum achievable by following a path from the top to the bottom
   */
  def greatestPath(grid: Array[Array[Int]]): Int = {
    for(i <- grid.size - 2 to 0 by -1) {
      for(j <- 0 to i) {
        grid(i)(j) = Math.max(grid(i)(j) + grid(i+1)(j), grid(i)(j) + grid(i+1)(j+1))
      }
    }
    grid(0)(0)
  }
}
