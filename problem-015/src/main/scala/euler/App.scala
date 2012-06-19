package euler.problem015

import euler.LogHelper

/**
 * <p>Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking)
 * to the bottom right corner.</p>
 * <p>How many routes are there through a 2020 grid?</p>
 */
object App extends LogHelper {

  def main(args: Array[String]) {
    /*
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
     * That should be equal to the number of permutations to get from tier 1 to tier 2, permutated
     * with the ways to get to tier 3, permuted with the ways to get to tier 4, permuted with the ways 
     * to get to tier 5.
     */
  }
  


}
