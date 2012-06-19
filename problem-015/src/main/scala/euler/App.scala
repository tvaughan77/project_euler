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

  /**
   * <p>Creates pair-wise permutations between every element of {@code xs} with every element of {@code ys}</p>
   * @param xs A list of strings
   * @param ys A list of strings
   * @return A list of lists of strings such that every string from {@code xs} is paired up with every string
   * from {@code ys} in a new list.  See unit test coverage for examples
   */
  def permute(xs: List[String], ys: List[String]): List[List[String]] = {
    if(xs.isEmpty)
      Nil
    else
      combine(xs.head, ys) ::: permute(xs.tail, ys)
  }
  
  /**
   * <p>Combines the {@code elem} with every element in {@code xs} to produce a list of lists.
   * For example combine("A", List("B", "C")) yields List(List("A", "B"), List("A", "C"))</p>
   * @param elem the element to combine pair wise with every element in {@code xs}
   * @param xs the list of elements to combine with {@code elem}
   * @return A list of lists - every inner list is the pairing of {@code elem} with each 
   * element in {@code xs} 
   */
  def combine(elem: String, xs: List[String]): List[List[String]] = {
    if(xs.isEmpty)
      Nil
    else
      (elem :: List(xs.head)) :: combine(elem, xs.tail)
  }
}
