fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val (n,m) = br.readLine().split(" ").map{ it.toInt()}
    
    val sb = StringBuilder()
    
    val arr = IntArray(m)
    val visited = BooleanArray(n)
    
    fun dfs(depth: Int){
        if(depth == m){
            arr.forEach{
                sb.append("$it ")
            }
            sb.append('\n')
            return
        }
        
        for(i in 0 until n){
            if(visited[i] == true) continue
            if(depth > 0 && arr[depth-1] > i+1) continue
            visited[i] = true 
            arr[depth] = i+1
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