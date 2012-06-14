package euler.problem012

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import euler.TriangleNumber


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The 1st triangle number is 1") {
    val triangle = new TriangleNumber()
    assertEquals(1, triangle(1))
  }


}



