import java.util.*;

fun main(){
    val (a,b,c) = readLine()!!.split(' ').map{ it.toInt() }
    print(division(a,b,c).toString())
}

fun division(a: Int, b: Int, c: Int): Long {
    if(b == 0){
        return 1L
    } 
    
    return when(b % 2){
        1 -> {
             val answer = division(a, b/2, c)
             (answer * answer % c) * a % c
        }
        else -> {
            val answer = division(a, b/2, c)
            (answer * answer) % c      
        }
    }
}