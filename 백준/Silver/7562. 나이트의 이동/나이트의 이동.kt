import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val testNum = br.readLine().toInt()

    val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    for (i in 0 until testNum) {
        val size = br.readLine().toInt()
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        val (endX, endY) = br.readLine().split(" ").map { it.toInt() }

        val visited = Array(size) { IntArray(size) }
        val que: Queue<Point> = LinkedList()
        
        if (x == endX && y == endY) {
            bw.append("0\n")
            continue
        }
        
        que.offer(Point(x, y))
        visited[x][y] = 1  

        loop@ while (que.isNotEmpty()) { 
            val target = que.poll()

            for (j in 0 until 8) {
                val nx = target.x + dx[j]
                val ny = target.y + dy[j]

                if (nx !in 0 until size || ny !in 0 until size || visited[nx][ny] != 0) continue

                if (nx == endX && ny == endY) {
                    bw.append("${visited[target.x][target.y]}\n")
                    break@loop 
                }

                visited[nx][ny] = visited[target.x][target.y] + 1
                que.offer(Point(nx, ny))
            }
        }
    }

    bw.flush()
    br.close()
    bw.close()
}