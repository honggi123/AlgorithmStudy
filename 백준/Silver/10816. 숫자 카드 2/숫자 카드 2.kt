import java.util.*;
import java.io.*;

// Map 사용
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    val inputN = readLine().split(" ").map {it.toInt()}

    val m = readLine().toInt()

    val inputM = readLine().split(" ").map {it.toInt()}

    val hashMap = HashMap<Int,Int>()

    repeat(n){
       hashMap[inputN[it]] = hashMap.getOrDefault(inputN[it],0) + 1;    
    }

    repeat(m) {
        bw.write("${hashMap[inputM[it]] ?: 0} ")
    }

    bw.flush()
    bw.close()
}

// 이진탐색 


