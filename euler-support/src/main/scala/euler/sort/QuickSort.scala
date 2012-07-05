package scalaapplication1.sort

/**
 * Pseudocode from wikipedia
 * <pre>
 *   function quicksort('array')
      if length('array') ≤ 1
          return 'array'  // an array of zero or one elements is already sorted
      select and remove a pivot value 'pivot' from 'array'
      create empty lists 'less' and 'greater'
      for each 'x' in 'array'
          if 'x' ≤ 'pivot' then append 'x' to 'less'
          else append 'x' to 'greater'
      return concatenate(quicksort('less'), 'pivot', quicksort('greater')) // two recursive calls
   </pre>
 */
object QuickSort {

  def sort[T](xs: List[T])(implicit num:Numeric[T]): List[T] = {
    if(xs.size <= 1) {
      xs
    }
    else {
      val pivot = xs.head
      val (less, greater) = partition(xs.tail, pivot)    // lots of memory held in stack here until tail comes back, no?
      sort(less) ::: List(pivot) ::: sort(greater)
    }
  }
  
  private def partition[T](xs: List[T], pivot: T)(implicit num:Numeric[T]): (List[T], List[T]) = {
    (xs filter (num.compare(_, pivot) <= 0), xs filter (num.compare(_, pivot) > 0))
  }
}
