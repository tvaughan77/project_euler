package euler.problem017

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {
  
  test("The word for 0 is 'zero'") {
    assertEquals("zero", App.num2word(0))
  }
  
  test("The word for 2 is 'two'") {
    assertEquals("two", App.num2word(2))
  }
  
  test("The word for 18 is 'eighteen'") {
    assertEquals("eighteen", App.num2word(18))
  }
  
  test("The word for 22 is 'twenty-two'") {
    assertEquals("twenty-two", App.num2word(22))
  }
  
  test("The word for 155 is 'one hundred and fifty-five") {
    assertEquals("one hundred and fifty-five", App.num2word(155))
  }
  
  test("The word for 839 is 'eight hundred and thirty-nine'") {
    assertEquals("eight hundred and thirty-nine", App.num2word(839))
  }
  
  test("The word for 100 is 'one hundred'") {
    assertEquals("one hundred", App.num2word(100))
  }
  
  test("The word for 1000 is 'one thousand'") {
    assertEquals("one thousand", App.num2word(1000))
  }
  
  test("The word for 342 is 'three hundred and forty-two'") {
    assertEquals("three hundred and forty-two", App.num2word(342))
  }
  
  test("It's an exception to ask num2word for a negative number") {
    intercept[IllegalArgumentException] {
      App.num2word(-55)
    }
  }
  
  test("It's an exception to ask num2word for a number greater than 1,000") {
    intercept[IllegalArgumentException] {
      App.num2word(2222)
    }
  }
  
  test("The number of letters in 342 is 23") {
    assertEquals(23, App.countLettersInSpelling(342))
  }
  
  test("The number of letters in 115 is 20") {
    assertEquals(20, App.countLettersInSpelling(115))
  }
  
  test("There are 19 letters in the words from (1..5) inclusive") {
    assertEquals(19, App.countLettersInNumbers(1, 5))
  }
}


