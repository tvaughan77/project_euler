package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class GridOperationsSuite extends FunSuite {

  test("Initializing a new 3x4 grid creates a 3x4 grid") {
    val rows = 3
    val cols = 4
    val grid = GridOperations.initialize(rows, cols)
    assertEquals(rows, grid.size)
    assertEquals(cols, grid(0).size)
  }
  
  test("Inverting a grid works") {
    val rows = 2
    val cols = 3
    val grid = GridOperations.initialize(rows, cols)
    grid(0)(0) = 1
    grid(0)(1) = 2
    grid(0)(2) = 3
    grid(1)(0) = 4
    grid(1)(1) = 5
    grid(1)(2) = 6
    
    val inverted = GridOperations.invert(grid)
    assertEquals(cols, inverted.size)
    assertEquals(rows, inverted(0).size)
    assertEquals(1, inverted(0)(0))
    assertEquals(4, inverted(0)(1))
    assertEquals(2, inverted(1)(0))
    assertEquals(5, inverted(1)(1))
    assertEquals(3, inverted(2)(0))
    assertEquals(6, inverted(2)(1))
  }
  
}
