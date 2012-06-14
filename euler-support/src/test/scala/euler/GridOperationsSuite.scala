package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class GridOperationsSuite extends FunSuite {

  val testSquareArray = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))   // a 3 x 3 array
  val testRectangularArray = Array(Array(10, 11, 12), Array(13, 14, 15))        // a 2 x 3 array
  
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
  
  test("Rotating a square grid works") {
    val rotated = GridOperations.rotate(testSquareArray)    
    
    assertEquals(3, rotated(0)(0))
    assertEquals(6, rotated(0)(1))
    assertEquals(9, rotated(0)(2))
    assertEquals(2, rotated(1)(0))
    assertEquals(5, rotated(1)(1))
    assertEquals(8, rotated(1)(2))
    assertEquals(1, rotated(2)(0))
    assertEquals(4, rotated(2)(1))
    assertEquals(7, rotated(2)(2))
  }
  
  test("Rotating a rectangular grid works") {
    val rotated = GridOperations.rotate(testRectangularArray)
        
    assertEquals(12, rotated(0)(0))
    assertEquals(15, rotated(0)(1))
    assertEquals(11, rotated(1)(0))
    assertEquals(14, rotated(1)(1))
    assertEquals(10, rotated(2)(0))
    assertEquals(13, rotated(2)(1))
  }
  
  test("The diagonal of my square test grid starting at (0,0) is (1, 5, 9)") {
    val diagonal = GridOperations.diagonal(testSquareArray, 0, 0)
    assertEquals("The diagonal.size should be 3", 3, diagonal.size)
    assertEquals("The diagonal(0) should be 1", 1, diagonal(0))
    assertEquals("The diagonal(1) should be 5", 5, diagonal(1))
    assertEquals("The diagonal(2) should be 9", 9, diagonal(2))
  }
  
  test("The diagonal of my square test grid starting at (0,1) is (2, 6)") {
    val diagonal = GridOperations.diagonal(testSquareArray, 0, 1)
    assertEquals(2, diagonal.size)
    assertEquals(2, diagonal(0))
    assertEquals(6, diagonal(1))
  }

  test("The diagonal of my square test grid starting at (1,0) is (4, 8)") {
    val diagonal = GridOperations.diagonal(testSquareArray, 1, 0)
    assertEquals(2, diagonal.size)
    assertEquals(4, diagonal(0))
    assertEquals(8, diagonal(1))
  }
  
  test("Asking for a diagonal starting from a too-high row results in errors") {
    intercept[IllegalArgumentException] {
      GridOperations.diagonal(testSquareArray, 9, 0)
    }
  }
  
  
  test("Asking for a diagonal starting from a too-high column results in errors") {
    intercept[IllegalArgumentException] {
      GridOperations.diagonal(testSquareArray, 0, 9)
    }
  }
  
  test("The diagonal of my rectangular test grid starting at (0, 0) is (10, 14)") {
    val diagonal = GridOperations.diagonal(testRectangularArray, 0, 0)
    assertEquals(2, diagonal.size)
    assertEquals(10, diagonal(0))
    assertEquals(14, diagonal(1))
  }
  
  test("The diagonal of my rectangular test grid starting at (1, 0) is (13)") {
    val diagonal = GridOperations.diagonal(testRectangularArray, 1, 0)
    assertEquals(1, diagonal.size)
    assertEquals(13, diagonal(0))
  }
  
  
}
