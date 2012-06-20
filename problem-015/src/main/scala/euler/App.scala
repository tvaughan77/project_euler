package euler.problem015

import euler.LogHelper
import euler.graph._
import scala.io.Source

/**
 * <p>Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking)
 * to the bottom right corner.</p>
 * <p>How many routes are there through a 2020 grid?</p>
 */
object App extends LogHelper {
  
  /** 
   * If you draw out the verticies of a grid and rotate the grid 45 degrees to make it look like 
   * a diamond (to achieve the "without backtracking" effect), it's clear that for an NxN grid there
   * are N+1 verticies across the fattest part of the diamond (the original diagonal).
   * 
   * So for a 2x2 grid, there are 3x3 verticies, rotated like a diamond looks like this:
   * 
   *              A            tier 1
   *           B     C         tier 2
   *        D     E     F      tier 3
   *           G     H         tier 4
   *              I            tier 5
   *              
   * We want to know how many distinct paths lead from vertex (A) to vertex (I).
   * 
   * Because we can't use straight permutations (i.e. there's no path from B-->F), we'll use a modified
   * depth-first-search approach:
   *  - start a stack with List(A) and a list of finished routes with List()
   *  - while stack is not empty,
   *  -- pop stack
   *  -- find last element of popped element
   *  -- if there are any routes from the last element, 
   *  --- create new lists with those routes and push back on to stack
   *  -- else
   *  --- move the popped element to the "finished routes" List
   */
  def main(args: Array[String]) {
     
//    val graph = Graph.loadFromResource(Source.fromInputStream(getClass.getResourceAsStream("graph_3x3.txt")))
//
//    val verticiesFrom = graph.verticiesFrom(Vertex("r1c1"))
//    
//    println("The verticies from r1c1 are" + verticiesFrom)
//    
//    val paths = graph.distinctPaths(Vertex("r1c1"))
//
//    println("The distinct paths from r1c1 are:\n" + paths + "\n")
//    
//    val answer = graph.distinctPaths(Vertex("r1c1")).size
//    println("According to this, there are " + answer + " distinct paths in a 3x3 grid, without backtracking")
//
    val graph = Graph.loadFromResource(Source.fromInputStream(getClass.getResourceAsStream("graph_21x21.txt")))

    val answer = graph.distinctPaths(Vertex("r10c10")).size

    println("According to this, there are " + answer + " distinct paths in a 20x20 grid, without backtracking")
  }
}
