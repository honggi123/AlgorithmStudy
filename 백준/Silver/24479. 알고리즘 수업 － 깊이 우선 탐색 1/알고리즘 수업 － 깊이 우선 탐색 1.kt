import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: IntArray
val sb = StringBuilder()
var cnt = 1

fun main (){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = br.readLine().split(" ").map{ it.toInt() }
    val n = arr[0]
    val m = arr[1]
    val r = arr[2]
    
    connected = Array(n+1){ ArrayList() }
    visited = IntArray(n+1){ 0 }
    
    repeat(m){
        var (v1, v2) = br.readLine().split(" ").map{ it.toInt() }
        connected[v1].add(v2)
        connected[v2].add(v1)
    } 
    
    connected.forEach { it.sort() }
    
    dfs(r)
    
   for (i in 1..n) {
    sb.append(visited[i]).append("\n")
    }
    print(sb)
    
    
    
}

fun dfs(idx: Int){
    if(visited[idx] != 0) return
    visited[idx] = cnt++
    
    connected[idx].forEach { next ->
        dfs(next)
    }
}

