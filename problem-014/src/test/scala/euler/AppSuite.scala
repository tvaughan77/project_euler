package euler.problem014

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The chain starting at 13 is (13  40  20  10  5  16  8  4  2  1)") {
    assertEquals(List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1), App.chain(13))
  }
  
}


