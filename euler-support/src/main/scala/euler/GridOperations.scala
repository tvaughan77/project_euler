package euler

import scala.io.Source

/**
 * Provides some common operations for working with 2D grids.
 */
object GridOperations {

  /**
   * // FIXME - how do I parameterize this with the hiccup caused by "map (_.toInt)" ?
   * @param source a stream of information (presumably a file containing rows x cols of integers
   * @return a 2D array of integers, parse from {@code source}
   */
  def parseDataGrid(source: Source, rows: Int, cols: Int): Array[Array[Int]] = {
    var data = initialize[Int](rows, cols)
    
    var row = 0
    for(line <- source.getLines) {
      data(row) = line.split(" ") map (_.toInt)
      row = row + 1
    }
    
    data
  }
  
  /**
   * @param rows how many rows in the grid
   * @param cols how many cols in the grid
   * @return a new 2D array of size {@code rows} x {@code cols}, initialized to the default value of the data type of the grid
   */
  def initialize[T](rows: Int, cols: Int)(implicit m: ClassManifest[T]): Array[Array[T]] = {
    var data = new Array[Array[T]](rows)
    for(i <- 0 until rows) {
      data(i) = new Array[T](cols)
    }
    data
  }
  
  /**
   * @param grid a 2D array
   * @return the {@code grid}, inverted such that what was in grid[x][y] is now in grid[y][x]
   */
  def invert[T](grid: Array[Array[T]])(implicit m: ClassManifest[T]): Array[Array[T]] = {
    val gridRows = grid.size
    val gridCols = grid(0).size
    
    val invertedGrid = initialize[T](gridCols, gridRows)
    
    for(i <- 0 until gridRows)
      for(j <- 0 until gridCols)
        invertedGrid(j)(i) = grid(i)(j)
    
    invertedGrid
  }
  
  /**
   * @param grid a 2D array
   * @return the {@code grid}, rotated 90 degrees counterclockwise. E.g., [[1 2] [3 4]] becomes [[2 4] [1 3]]
   */
  def rotate[T](grid: Array[Array[T]])(implicit m: ClassManifest[T]): Array[Array[T]] = {
    val gridRows = grid.size
    val gridCols = grid(0).size
    
    val rotatedGrid = initialize[T](gridCols, gridRows)
    for(i <- 0 until gridRows)
      for(j <- 0 until gridCols)
        rotatedGrid(gridCols - j - 1)(i) = grid(i)(j)

    rotatedGrid
  }
  
  /**
   * @param grid a 2D array
   * @param x the starting column
   * @param y the starting row
   * @return the numbers along the diagonal of the grid starting from (x, y) and going "down and to the right"
   */
  def diagonal[T](grid: Array[Array[T]], startRow: Int, startCol: Int)(implicit m: ClassManifest[T]): Array[T] = {
    require(startRow < grid.size)
    require(startCol < grid(0).size)
    
    var data = new scala.collection.mutable.ListBuffer[T]
    
    var row = startRow
    var col = startCol
    while(row < grid.size && col < grid(0).size) {
      data += grid(row)(col)
      row = row + 1
      col = col + 1
    }
    
    data.toArray
  }
  
  /**
   * <p>Spits out the contents of {@code grid} to stdout
   * @param grid a 2D array
   */
  def printGrid[T](grid: Array[Array[T]]) {
    for(i <- 0 until grid.size) {
      printArray(grid(i))
    }
  }
  
  def printArray[T](array: Array[T]) {
    for(i <- 0 until array.size) {
      print(array(i) + " ")
    }
    print("\n")    
  }
  
  /**
   * @param grid a 2D array of numbers
   * @return a single array (same width as {@code grid}) that contains the sum of all the values in the 2D input.
   * For example, the 0th index of the return array is the sum of the 0th elements of all the rows in the grid.  
   * 10's digits do not "carry over", you need to do that yourself.
   */
  def sumGrid[T](grid: Array[Array[T]])(implicit m: ClassManifest[T], num: Numeric[T]): Array[T] = {
    val sum = new Array[T](grid(0).size)
    
    for(i <- 0 until grid.size) {
      for(j <- 0 until grid(0).size) {
        sum(j) = num.plus(sum(j), grid(i)(j))
      }
    }  
    sum
  }
}
