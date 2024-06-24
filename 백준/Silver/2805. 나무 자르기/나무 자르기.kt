import java.util.*;
import java.io.*;

var maxHeight = 1L
var minHeight = 1L
var M = 0L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var N : Long = st.nextToken().toLong() // 나무의 수 N
    M = (st.nextToken()).toLong() // 나무의 길이 M
    val trees = LongArray(N.toInt()) // 나무 길이가 담긴 배열

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) {
        trees[i.toInt()] = (st.nextToken()).toLong()
        maxHeight = Math.max(maxHeight, trees[i.toInt()])
    }

    binarySearch(trees)
} 

fun binarySearch(trees: LongArray){
    var start = minHeight
    var end = maxHeight
    var mid = 0L 
    
    while(start <= end){
        var treeLength = getCutTreeLength(trees, mid)
        
        if(treeLength >= M){
            start = mid + 1
        }else{
            end = mid - 1
        }
        mid = (start + end) / 2
    }
    
    print(mid)
}

fun getCutTreeLength(trees: LongArray, target: Long): Long {
    var sum = 0L
    trees.forEach {
        if(it >= target){
           sum += (it - target) 
        }
    }
    return sum
}
