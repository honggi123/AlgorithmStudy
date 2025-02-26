import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val list = arrayListOf<Int>()
    
    for(i in 0 until k){
        list.add(br.readLine().toInt())
    }
    
    list.sort()
    for(num in list){
        println(num)
    }
}