fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val t = br.readLine().toInt()
    repeat(t){
        val (m,n,k) = br.readLine().split(" ").map{ it.toInt() }
        val arr = Array(m){ IntArray(n){0} }
        val visited = Array(m){ BooleanArray(n){ false }}
        
        val dx = arrayOf(0,1,0,-1)
        val dy = arrayOf(1,0,-1,0)
        
        var cnt = 0 
        
        repeat(k){
            val (x,y) = br.readLine().split(" ").map{ it.toInt() }
            arr[x][y] = 1
        }
        
       fun dfs(x: Int, y: Int){
            visited[x][y] = true
            
            for(i in 0 until 4){
               val nx = x + dx[i]
               val ny = y + dy[i]
               if (nx in 0 until m && ny in 0 until n && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny)
               }
            }
        }
        
        for(i in 0 until m){
            for(j in 0 until n){
                if(visited[i][j] == false && arr[i][j] == 1){
                    cnt++
                    dfs(i,j)
                }
            }
        }
        
        bw.write("$cnt\n")
    }
    bw.flush()
 }