import java.util.*;

// Map 사용

//    fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//        val n = readLine().toInt()
//
//        val inputN = readLine().split(" ").map {it.toInt()}
//
//        val m = readLine().toInt()
//
//        val inputM = readLine().split(" ").map {it.toInt()}
//
//        val hashMap = HashMap<Int,Int>()
//
//        repeat(n){
//            hashMap[inputN[it]] = hashMap.getOrDefault(inputN[it],0) + 1;
//        }
//
//        repeat(m) {
//            bw.write("${hashMap[inputM[it]] ?: 0} ")
//        }
//
//        bw.flush()
//        bw.close()
//    }

// 이진탐색 
fun main() = with(Scanner(System.`in`)) {
   val strBuilder = StringBuilder();

   val n = nextInt()

   val inputN = IntArray(n)
    
   for(i in 0 until n) {
      inputN[i] = nextInt()
   }
   
   Arrays.sort(inputN)
    
   val m = nextInt()
    
   for(i in 0 until m) {
      val key = nextInt() 
       
      strBuilder.append(upperBinarySeach(inputN, key) - lowerBinarySeacrh(inputN, key))
       .append(' ')
   }
    
   println(strBuilder)
}

fun lowerBinarySeacrh(array: IntArray, key: Int): Int {
    var left = 0
    var right = array.size

    while (left < right){
        val midIndex = (left + right) / 2
        val target = array[midIndex]

        if (key <= target){
            right = midIndex
        } else{
            left = midIndex + 1
        }
    }
    return left
}

fun upperBinarySeach(array: IntArray, key: Int): Int {
    var left = 0
    var right = array.size

    while (left < right){
        val midIndex = (left + right) / 2
        val target = array[midIndex]

        if (key < target){
            right = midIndex
        } else{
            left = midIndex + 1
        }
    }
    return left
}
