package euler.problem011

import scala.io.Source

/**
 * 
 */
object DataGridReader {

  private final val SIZE = 20
  
  /**
   * @param source a stream of information (presumably a file containing 20 rows & 20 columns of integers
   * @return a 2D array of integers, parse from {@code source}
   */
  def parseDataGrid(source: Source): Array[Array[Int]] = {
    
    var data = new Array[Array[Int]](SIZE)
    for(i <- (0 to SIZE - 1)) {
      data(i) = new Array[Int](SIZE)
    }
    
    var row = 0
    for(line <- source.getLines) {
      data(row) = line.split(" ") map (_.toInt)
      row = row + 1
    }
    
    data
  }
}
