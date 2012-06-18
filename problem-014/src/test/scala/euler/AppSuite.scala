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
  
  test("Cache should be hit") {
    assertEquals(List(8, 4, 2, 1), App.chain(8))
    assertEquals(List(16, 8, 4, 2, 1), App.chain(16))   // I should see this hit the cache
  }
  
  test("Why does this hit a stack overflow error") {
    val chain = App.chain(60415)
    println("The chain for 60415 is " + chain)
  }
}


