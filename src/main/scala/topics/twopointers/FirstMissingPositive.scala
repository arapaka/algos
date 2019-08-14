package topics.twopointers

/**
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
 a[Math.abs(a[3]-1])] = -a[Math.abs(a[3-1])] => a[a[2]] = -a[a[2]] => a[1] = -a[1] => [-3,4,-1,1]
 a[Math.abs(a[4-1])] = -a[Math.abs(a[4-1])] => a[a[3]] = -a[a[3]] => a[3] = -a[3] => [-3,4,-1,-1]
 a[Math.abs(a[-1-1])] = -a[Math.abs(a[-1-1])] => a[a[2]] = -a[a[2]] => a[1] = -a[1] => [-3,4,1,-1]
 a[Math.abs(a[-1-1])] = -a[Math.abs(a[-1-1])] => a[a[2]] = -a[a[2]] => a[1] = -a[1] => [-3,4,1,-1]

Your algorithm should run in O(n) time and uses constant space.
 */

object FirstMissingPositive extends App {
 println("hello")

  def findFirstMissingPositive(array: Array[Int])  = {
    val positive = array.filter(i => i > 0).toBuffer

    //a[a[i]-1] = -a[a[i]-1] , where a[i]-1 < a.length
    // Now from 0 to array.length, return if there is any element if it is positive
    //[3,4,-1,1] = positive (3,4,1)
    // loop i <
    // i = 0: one = abs(positive(0)) = 3 , nextIF , one-1 = 2 < positive.length (3) and positive(2-1) = positive(1)=4
    // array becomes : [3,-4,1]
    //i = 1: one = abs(positive(1)) = 4 , nextIF , one-1 = 3 < positive.length(3)[false]
    // array stays : [3,-4,1]
    //i= 2 : one = abs(positive(2))= 1, nextIF , one-1 = 0 < positive.length(3)[true] and positive(0) = -positive(0)
    //array becomes: [-3,-4,1]
    // first positive index = 1 and the number would be 1 + 1 = 2
    for (i <- positive.indices) {
        val one = Math.abs(positive(i))
        if(one-1 < positive.length && positive(one-1) > 0) {
          positive(one-1) = -positive(one-1)
        }
    }
    var missing = positive.indices.end + 1
   for(i <- positive.indices) {
     if(positive(i) > 0) {
       missing = i+1
     }
   }
    missing
  }

  {
    val array = Array(0,1,2)
    println(findFirstMissingPositive(array))
  }


}
