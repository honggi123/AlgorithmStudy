import java.util.*

var n:Int = 0
var m:Int = 0

fun main(args:Array<String>) {
    val scr = Scanner(System.`in`)
    
    n = scr.nextInt()
    m = scr.nextInt()
    
    var arr = IntArray(n) { -1 } 
    
    for(i in 0 until n){
        arr[i] = scr.nextInt()
    }
    
    val max = calculate(arr)
    
    println(max)
}

fun calculate(arr: IntArray): Int {
    val pq = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
        o2 - o1
    })
    
    for(i in 0 until n){
        for(j in i+1 until n){
           for(k in j+1 until n){
               val sum = arr[i] + arr[j] + arr[k]
               if(sum == m){
                   pq.add(sum)
                   return pq.poll()
               }
               if(sum > m){
                   continue
               }
               if(sum < m){
                   pq.add(sum)
               }
           } 
        }
    }
    
    return pq.poll()
}
