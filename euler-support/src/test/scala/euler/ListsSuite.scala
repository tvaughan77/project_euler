package euler

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  val tier1 = List("A")
  val tier2 = List("B", "C")
  val tier3 = List("D", "E", "F")
  
  test("Combining 'A' with List('B', 'C') yields List(List('A', 'B'), ('A', 'C'))") {
    assertEquals(List(List("A", "B"), List("A", "C")), Lists.combine("A", tier2))
  }
  
  test("Permuting tier1 with tier2 yields List(List('A', 'B'), ('A', 'C'))") {
    assertEquals(List(List("A", "B"), List("A", "C")), Lists.permute(tier1, tier2))
  }
  
  test("Permuting tier2 with tier3 yields a 6-element permutation (2x3 = 6)") {
    assertEquals(List(List("B", "D"), 
                      List("B", "E"), 
                      List("B", "F"), 
                      List("C", "D"), 
                      List("C", "E"), 
                      List("C", "F")),
                 Lists.permute(tier2, tier3))
  }
}
