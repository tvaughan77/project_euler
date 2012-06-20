package euler.problem015

import euler.LogHelper
import scala.io.Source

/**
 * <p>Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking)
 * to the bottom right corner.</p>
 * <p>How many routes are there through a 2020 grid?</p>
 */
object App extends LogHelper {
  
  /** 
   * <p>This problem demands some dynamic programming by building up an understanding of how many paths
   * exist from some Vertex to the bottom-right corner.  This algorithm will work because of the
   * constraint we're given that one can only go "down" or "right".</p>
   * 
   * <p>Consider a grid like:<br/>
   * <pre>
   *      a         b         c
   *      
   *      d         e         f
   *      
   *      g         h         i
   * </pre>
   * </p>
   * 
   * <p>We know that there is just 1 way to get from h->i and just 1 way to get from f->i, which we can annotate
   * like:<br/>
   * <pre>
   *      a         b         c
   *      
   *      d         e         f[1]
   *      
   *      g         h[1]      i
   * </pre> 
   * </p>
   * 
   * <p>When considering vertex "e", we note that we can get to "i" either by going down through h or by going
   * right through f.  That's 2 possible paths, which happens to be the sum of h[1] + f[1] = e[2].  Filling in
   * the rest of the grid with that logic shows me that I'm on the right path:<br/>
   * <pre>
   *      a[6]      b[3]      c[1]
   *      
   *      d[3]      e[2]      f[1]
   *      
   *      g[1]      h[1]      i
   * </pre> 
   * </p>
   * <p>As expected, there are 6 ways to get from node "a" to node "i" 
   * 
   */
  def main(args: Array[String]) {
    val dim = 20
    println("The number of paths in a " + dim + "x" + dim + " square is = " + numberOfPaths(dim+1))
  }
 

  /**
   * @param dim the dimensions of a square for which we're asking "How many paths are there from the top left
   * to the bottom right, without going up or left?"
   * @return the number of distinct such paths
   */ 
  def numberOfPaths(dim: Int): Double = {
     val grid = initializeGrid(dim)
     
     for(row <- (dim - 2) to 0 by -1) {
       for(col <- (dim - 2) to 0 by -1) {
         grid(row)(col) = grid(row + 1)(col) + grid(row)(col + 1)
       }
     }
     
     grid(0)(0)
  } 
 
  /**
   * FIXME - replace the first initialization part of this method with a parameterized GridOperations method
   * @param dim the dimensions (x & y) of the square grid to initialize
   * @return a 2-D array of Doubles of size dim by dim.  For this problem, we initialize the bottom
   * row and right column with "1"s and everything else with "0"s.  The bottom right corner is "0" which
   * reflects the notion that there's no way starting at the bottom right to travel across a down- or 
   * right- edge to itself.
   */
  private def initializeGrid(dim: Int): Array[Array[Double]] = {
    var grid = new Array[Array[Double]](dim)
    for(i <- 0 until dim) {
      grid(i) = new Array[Double](dim)
    }
    
    // Every vertex along the bottom of the grid has just 1 path to the bottom right corner (straight right)
    // And every vertex along the right side of the grid has just 1 path to the bottom right corner (straight down)
    for(i <- 0 until dim) {
      grid(dim - 1)(i) = 1
      grid(i)(dim - 1) = 1
    }
    // But the bottom right corner shouldn't have any paths to itself
    grid(dim - 1)(dim - 1) = 0
    
    grid
  }
}
