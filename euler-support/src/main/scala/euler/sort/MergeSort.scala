package scalaapplication1.sort


object MergeSort {

  def sort[T](xs: List[T])(implicit num: Numeric[T]): List[T] = {
    if(xs.size <= 1) {
      xs
    } 
    else {
      val (left, right) = split(xs)
      merge(sort(left), sort(right)) 
    }
  }
  
  private def merge[T](xs: List[T], ys: List[T])(implicit num: Numeric[T]): List[T] = {
    if(xs.isEmpty && ys.isEmpty)
      Nil
    else if(xs.isEmpty)
      ys
    else if(ys.isEmpty)
      xs
    else if(num.compare(xs.head, ys.head) < 0)    // xs.head < ys.head
      xs.head :: merge(xs.tail, ys)
    else
      ys.head :: merge(xs, ys.tail)
  }
  
  private def split[T](xs: List[T])(implicit num:Numeric[T]): (List[T], List[T]) = {
    xs.splitAt(xs.size / 2)
  }
  
  
  
}
