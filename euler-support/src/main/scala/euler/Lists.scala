package euler

object Lists {
  /**
   * <p>Creates pair-wise permutations between every element of {@code xs} with every element of {@code ys}</p>
   * @param xs A list of strings
   * @param ys A list of strings
   * @return A list of lists of strings such that every string from {@code xs} is paired up with every string
   * from {@code ys} in a new list.  See unit test coverage for examples
   */
  def permute(xs: List[String], ys: List[String]): List[List[String]] = {
    if(xs.isEmpty)
      Nil
    else
      combine(xs.head, ys) ::: permute(xs.tail, ys)
  }
  
  /**
   * <p>Combines the {@code elem} with every element in {@code xs} to produce a list of lists.
   * For example combine("A", List("B", "C")) yields List(List("A", "B"), List("A", "C"))</p>
   * @param elem the element to combine pair wise with every element in {@code xs}
   * @param xs the list of elements to combine with {@code elem}
   * @return A list of lists - every inner list is the pairing of {@code elem} with each 
   * element in {@code xs} 
   */
  def combine(elem: String, xs: List[String]): List[List[String]] = {
    if(xs.isEmpty)
      Nil
    else
      (elem :: List(xs.head)) :: combine(elem, xs.tail)
  }
}
