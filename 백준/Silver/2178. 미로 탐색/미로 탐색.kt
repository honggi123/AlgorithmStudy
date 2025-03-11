import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Point(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y] - '0'
        }
    }

    bfs(n, m, map)
}

fun bfs(n: Int, m: Int, map: Array<Array<Int>>) {
    val graph = Array(n){ IntArray(m){ 0 } }
    val que = LinkedList<Point>()
    que.add(Point(0,0))
    graph[0][0] = 1
    
    while(que.isNotEmpty()){
        val point = que.poll()
        
        for(i in 0 until 4){
           val nx = point.x + dx[i]
           val ny = point.y + dy[i]
            
           if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
           if(graph[nx][ny] > 0 || map[nx][ny] == 0) continue
           graph[nx][ny] = graph[point.x][point.y] + 1
            
            if (nx == n - 1 && ny == m - 1) {
                println(graph[nx][ny])
                break
            }
           que.offer(Point(nx,ny))
         }
    }
    
}