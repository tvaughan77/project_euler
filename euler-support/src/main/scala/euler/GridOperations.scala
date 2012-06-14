package euler

import scala.io.Source

/**
 * Provides some common operations for working with 2D grids.
 * 
 * // FIXME - abstract the data type from just "Int"
 */
object GridOperations {

  /**
   * @param source a stream of information (presumably a file containing rows x cols of integers
   * @return a 2D array of integers, parse from {@code source}
   */
  def parseDataGrid(source: Source, rows: Int, cols: Int): Array[Array[Int]] = {
    var data = initialize(rows, cols)
    
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
  def initialize(rows: Int, cols: Int): Array[Array[Int]] = {
    var data = new Array[Array[Int]](rows)
    for(i <- 0 until rows) {
      data(i) = new Array[Int](cols)
    }
    data
  }
  
  /**
   * @param grid a 2D array
   * @return the {@code grid}, inverted such that what was in grid[x][y] is now in grid[y][x]
   */
  def invert(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val gridRows = grid.size
    val gridCols = grid(0).size
    
    val invertedGrid = initialize(gridCols, gridRows)
    
    for(i <- 0 until gridRows)
      for(j <- 0 until gridCols)
        invertedGrid(j)(i) = grid(i)(j)
    
    invertedGrid
  }
  
  /**
   * @param grid a 2D array
   * @return the {@code grid}, rotated 90 degrees counterclockwise. E.g., [[1 2] [3 4]] becomes [[2 4] [1 3]]
   */
  def rotate(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val gridRows = grid.size
    val gridCols = grid(0).size
    
    val rotatedGrid = initialize(gridCols, gridRows)
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
  def diagonal(grid: Array[Array[Int]], startRow: Int, startCol: Int): Array[Int] = {
    require(startRow < grid.size)
    require(startCol < grid(0).size)
    
    var data = new scala.collection.mutable.ListBuffer[Int]
    
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
  def printGrid(grid: Array[Array[Int]]) {
    for(i <- 0 until grid.size) {
      for(j <- 0 until grid(0).size) {
        print("%4d".format(grid(i)(j)))
      }
      print("\n")
    }
  }
}
