import java.util.*

data class Node(val index: Int, val distance: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int{
        return distance - other.distance // 오름차순 정렬
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map{ it.toInt() }
    val k = readLine().toInt()
    val result = IntArray(v + 1) { Int.MAX_VALUE }.apply { this[k - 1] = 0 }
    val graph = MutableList(v) { PriorityQueue<Node>() }

    repeat(e) {
        val (u, vv, w) = readLine().split(" ").map { it.toInt() }
        graph[u - 1].add(Node(vv - 1, w))
    }
    
    val pq = PriorityQueue<Node>().apply{
        offer(Node(k-1,0)) // 첫번째 노드 추가
    }
    
    while(pq.isNotEmpty()){
        val curNode = pq.poll()
        
        if(curNode.distance > result[curNode.index]) continue
        
        for(node in graph[curNode.index]){ // 인접 노드
            if(node.distance + result[curNode.index] < result[node.index]){
                result[node.index] = node.distance + result[curNode.index]
                pq.offer(Node(node.index, result[node.index]))
            }
        }
    }
 
    for (i in 0 until v) {
        if (result[i] == Int.MAX_VALUE)
            println("INF")
        else
            println(result[i])
    }
}