import java.util.* 

data class Point(val x: Int, val y: Int)

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    var count0 = 0
    
    val (m,n) = br.readLine().split(" ").map{ it.toInt() }
    val arr = Array(n){ IntArray(m) }
    val que: Queue<Point> = LinkedList()
    
    val dx = arrayOf(0,1,0,-1)
    val dy = arrayOf(1,0,-1,0)
    
    for(i in 0 until n){
       arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1) que.add(Point(i, j))
            else if(arr[i][j] == 0) count0++
        }
    }
    
    
    fun bfs(): Int{
       var day = 0 
        
       while(que.isNotEmpty()){
           val q = que.poll()
           day = arr[q.x][q.y]
           
           for(i in 0 until 4){
               val nx = q.x + dx[i]
               val ny = q.y + dy[i]
               
               if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
               
               if(arr[nx][ny] == 0){
                   arr[nx][ny] = day + 1
                   que.add(Point(nx,ny))
                   count0--
               }
           }
       } 
       return if(count0 == 0) day -1
       else -1
    }
 
    bw.write("${bfs()}")
    bw.flush()
    bw.close()
}