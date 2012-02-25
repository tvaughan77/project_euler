package euler.problem004

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("Single digits are palindromes") {
    for(i <- 0 to 9) {
      assertTrue(App.isPalindrome(i))
    }
  }
  
  test("1331 is a palindrome") {
    assertTrue(App.isPalindrome(1331))
  }
  
  test("717 is a palindrome") {
    assertTrue(App.isPalindrome(717))
  }
  
  test("874918493 is not a palindrome") {
    assertFalse(App.isPalindrome(874918493))
  }
}


