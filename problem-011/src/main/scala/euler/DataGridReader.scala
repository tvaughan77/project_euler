package euler.problem011

import scala.io.Source

/**
 * Parses a rows x cols text file of integers into a 2D array of appropriate size
 */
object DataGridReader {

  /**
   * @param source a stream of information (presumably a file containing rows x cols of integers
   * @return a 2D array of integers, parse from {@code source}
   */
  def parseDataGrid(source: Source, rows: Int, cols: Int): Array[Array[Int]] = {
    
    var data = new Array[Array[Int]](rows)
    for(i <- (0 to rows - 1)) {
      data(i) = new Array[Int](cols)
    }
    
    var row = 0
    for(line <- source.getLines) {
      data(row) = line.split(" ") map (_.toInt)
      row = row + 1
    }
    
    data
  }
}
