fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val n = br.readLine().toInt()
 
    val col = BooleanArray(n)

    val diag1 = BooleanArray(n*2)
    val diag2 = BooleanArray(n*2)
    var cnt = 0
    
    fun dfs(depth: Int){
        if(depth == n){
            cnt++
            return
        }
        
        for(i in 0 until n){
            if(col[i] == true || diag1[depth+i] == true || diag2[i-depth+(n-1)]) continue
            col[i] = true
            diag1[depth+i] = true
            diag2[i-depth+(n-1)] = true
            dfs(depth+1)
            diag2[i-depth+(n-1)] = false
            diag1[depth+i] = false
            col[i] = false
        }
    }
    
    dfs(0)
    
    bw.append("${cnt}")

    bw.flush()
    bw.close()
    br.close()
}