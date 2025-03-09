import java.util.*

fun main(){
     val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
 
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = IntArray(m) 
    val visited = BooleanArray(n) 
    
    val sb = StringBuilder()
    
    fun dfs(depth:Int){
        if(depth == m){
            arr.forEach {
                sb.append("$it ")
            }
            sb.append('\n')
            return
        }
        
        for(i in 0 until n){
            if(visited[i] == true) continue
            arr[depth] = i+1
            visited[i] = true
            dfs(depth+1)
            visited[i] = false
        }
    }
    
    dfs(0)
 
    bw.write("$sb")
    bw.flush()
    bw.close()
    br.close()
}