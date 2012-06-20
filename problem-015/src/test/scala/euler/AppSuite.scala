package euler.problem015

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("There are 2 paths in a 1 square cube grid") {
    assertEquals(2, App.numberOfPaths(2).intValue)
  }
  
  test("There are 6 paths in a 2x2 square cube grid") {
    assertEquals(6, App.numberOfPaths(3).intValue)
  }
  
  test("There are 20 paths in a 3x3 square cube grid") {
    assertEquals(20, App.numberOfPaths(4).intValue)
  }
}


