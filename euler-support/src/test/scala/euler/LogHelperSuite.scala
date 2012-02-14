package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


@RunWith(classOf[JUnitRunner])
class LogHelperSuite extends FunSuite {

  test("Constructing a class that uses LogHelper to see if I can get it to log") {
    val clazz = new SomeClassUsingLogHelper()
  }
}
