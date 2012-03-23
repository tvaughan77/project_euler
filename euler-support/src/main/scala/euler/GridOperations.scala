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
    for(i <- (0 to rows - 1)) {
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
    
    for(i <- (0 to gridRows - 1))
      for(j <- (0 to gridCols - 1))
        invertedGrid(j)(i) = grid(i)(j)
    
    invertedGrid
  }
}
