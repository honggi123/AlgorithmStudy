import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    val (n,k) = getIntList()
    val q: Queue<Int> = LinkedList()
    for(i in 1 .. n){
        q.add(i)
    }
    write("<")
    while(q.isNotEmpty()){
        var index = 0
        while(index < k-1){
            val firstItem = q.poll()
            q.add(firstItem) // add last
            index += 1
        }
        write("${q.poll()}")
        if(q.isNotEmpty()){
            write(", ")
        }
    }
    write(">")
    close()
}