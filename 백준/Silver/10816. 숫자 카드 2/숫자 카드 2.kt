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
fun main() = with(Scanner(System.`in`)){

    val strBuilder = StringBuilder()
    val N = nextInt()
    val array = IntArray(N)

    for (i in 0 until N){
        array[i] = nextInt()
    }

    Arrays.sort(array)

    val M = nextInt()

    for (i in 0 until M){
        val key = nextInt()

        strBuilder.append(upperBound(array, key) - lowerBound(array, key)).append(' ')
    }
    println(strBuilder)
}

fun lowerBound(array: IntArray, key: Int): Int {
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

fun upperBound(array: IntArray, key: Int): Int {
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

