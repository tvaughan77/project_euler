package euler.problem004

/**
 * <p>A palindromic number reads the same both ways.<br/>
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.</p>
 * 
 * <p>Find the largest palindrome made from the product of two 3-digit numbers.</p>
 * 
 * Design thoughts:
 * 1) What's the best way to write a palindrome detector?
 * 2) What's the "right" math to determine how to work backwards from 999 * 999 to the next highest product?  I think it's a
 * zig-zag pattern, but convince myself of that...
 * 
        990	991	992	993	994	995	996	997	998	999	
990	980100	981090	982080	983070	984060	985050	986040	987030	988020	989010	
991	981090	982081	983072	984063	985054	986045	987036	988027	989018	990009	
992	982080	983072	984064	985056	986048	987040	988032	989024	990016	991008	
993	983070	984063	985056	986049	987042	988035	989028	990021	991014	992007	
994	984060	985054	986048	987042	988036	989030	990024	991018	992012	993006	
995	985050	986045	987040	988035	989030	990025	991020	992015	993010	994005	
996	986040	987036	988032	989028	990024	991020	992016	993012	994008	995004	
997	987030	988027	989024	990021	991018	992015	993012	994009	995006	996003	
998	988020	989018	990016	991014	992012	993010	994008	995006	996004	997002	
999	989010	990009	991008	992007	993006	994005	995004	996003	997002	998001

 999 * 999 = 998001
 999 * 998 = 997002
 998 * 998 = 996004
 998 * 997 = 996003
 998 * 997 = 995006
 
 
 	1	2	3	4	5	6	7	8	9	10	
1	1	2	3	4	5	6	7	8	9	10	
2	2	4	6	8	10	12	14	16	18	20	
3	3	6	9	12	15	18	21	24	27	30	
4	4	8	12	16	20	24	28	32	36	40	
5	5	10	15	20	25	30	35	40	45	50	
6	6	12	18	24	30	36	42	48	54	60	
7	7	14	21	28	35	42	49	56	63	70	
8	8	16	24	32	40	48	56	64	72	80	
9	9	18	27	36	45	54	63	72	81	90	
10	10	20	30	40	50	60	70	80	90	100

 10 * 10 = 100
 10 * 9  =  90
 9  * 9  =  81
 10 * 8  =  80
 9  * 8  =  72
 8  * 8  =  64
 9  * 7  =  63
 10 * 7  =  60
 8  * 7  =  56
 9  * 6  =  54
 10 * 5  =  50
 7  * 7  =  49
 8  * 6  =  48
 9  * 5  =  45
 10 * 4  =  40
 6  * 6  =  36
 
 * 
 */
object App {

  def main(args: Array[String]) {

    print("The largest palindrome of the product of two 3-digit numbers is " + 
          ((makeSetOfAllThreeDigitProducts() filter (isPalindrome(_))) max) +
          "\n"
    )
    
  }
  
  

  /**
   * FIXME - even computing this is stupid - there's got to be a better algorithm for working backwards from a multiplication
   * table, but I'm having a hard time deriving an (i,j)-based function from a simple 10x10 table
   * 
   * <p>Another scala solution I saw in the Project Euler board seems a little flawed.  This guys submitted this code which
   * works (gets the same answer), but I think he's using magic numbers by only going from 999 to 900...why not 100?  If you
   * chanage his 900s to 100s you get the wrong answer.  Still, I like the conciseness of his more than my brute-force
   * approach:<br/>
   * <pre>
  
    for ( 
      i <- 999 to 100 by -1; 
      j <- 999 to 100 by -1
      if(isPalindrome(i * j))
    ) { 
      print(i + " * " + j + " = " + i * j + "\n")
      sys.exit
    }
    
   </pre>
    </p>
   * 
   * @return a set of all of the unique products of all 3 digit numbers
   */  
  def makeSetOfAllThreeDigitProducts(): Set[Int] = {
    // Creates a 2D multiplication table, then flattens it out
    val products = List.tabulate(1000,1000)(_ * _) flatMap (_.toList)

    val productSet = scala.collection.mutable.Set.empty[Int]
    for(product <- products) {
      productSet += product
    }
    
    // Remove any product that isn't bigger than the smallest product of two 3 digit numbers
    productSet filter (_ > (100*100))
    
    productSet.toSet
  }

  /**
   * A numerical palindrome is just what you'd expect -- "1331" is, "83782" is not.  I'm making an arbitrary decision to define
   * single digits as palindromes of themselves and thus the number "717" is a palindrome too, just like the word "mom" or "dad"
   * is.
   * 
   * @param n a number to check for palindrome-ness
   * @return true, if {@code n} is a paldindrome.  False otherwise. 
   */
  def isPalindrome(n: Int): Boolean = {
    def isp(chars: Array[Char]): Boolean = 
      if (chars.length == 0) true
      else if (chars.length == 1) true
      else if (! chars.head.equals(chars.last)) false
      else isp(chars.init.tail)
    
    isp(n.toString.toCharArray)
  }
}
