package euler.problem018

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import scala.io.Source
import euler.LogHelper
import euler.GridOperations


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The greatest path of our test triangle is 23") {
    val source = Source.fromInputStream(getClass.getResourceAsStream("test_triangle.txt"))
    val grid = GridOperations.parseDataGrid(source, 4, 4)
    assertEquals(23, App.greatestPath(grid))
  }
}


