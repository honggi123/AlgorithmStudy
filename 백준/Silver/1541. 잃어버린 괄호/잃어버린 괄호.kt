import java.util.*;

fun main() = with(System.`in`.bufferedReader()) {
    val strList = readLine().split("-")
    var firstNum = strList[0].split('+').sumOf{ it.toInt() }
    
    for(i in 1 until strList.size){
        firstNum -= strList[i].split('+').sumOf{ it.toInt() }
    }
    println(firstNum)
}