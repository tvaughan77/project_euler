package euler.problem011

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {
  val testSquareArray = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))   // a 3 x 3 array
  val testRectangularArray = Array(Array(10, 11, 12), Array(13, 14, 15))        // a 2 x 3 array
  
  
  test("The greatest product of width 3 in [1, 2, 3, 4, 5, 6, 7, 8, 9] is (7*8*9) = 504") {
    assertEquals(72, App.computeGreatestProduct(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 2))
    assertEquals(504, App.computeGreatestProduct(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
    assertEquals(72, App.computeGreatestProduct(Array(9, 8, 7, 6, 5, 4, 3), 2))
    assertEquals(6, App.computeGreatestProduct(Array(1, 2, 1, 1, 2, 3, 1, 1, 1, 1, 2), 4))
    assertEquals(1, App.computeGreatestProduct(Array(0, 0, 1, 0, 1, 0, 0), 1))
    assertEquals(0, App.computeGreatestProduct(Array(0, 0, 1, 0, 1, 0, 0), 2))
  }
  

  test("The greatest product of diagonals on my square test grid is 1*5*9 = 45") {
    assertEquals(45, App.computeGreatestDiagProduct(testSquareArray, 3))
  }
  
  test("The greatest product of diagonals on my rectangular grid is 11 * 15 = 165") {
    assertEquals(165, App.computeGreatestDiagProduct(testRectangularArray, 2))
  }
}


