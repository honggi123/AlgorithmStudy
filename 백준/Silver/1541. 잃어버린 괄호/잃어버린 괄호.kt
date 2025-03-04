fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val list = mutableListOf<Int>()
    
    br.readLine().split("-").forEach { s ->
           var sum = 0                          
           s.split("+").forEach {
              sum += it.toInt()
           }
           list.add(sum)                           
    }
    
    var result = list[0] 
    
    for (i in 1 until list.size) {
        result -= list[i]
    }
    
    bw.append("${result}")
    
    bw.flush()
    bw.close()
}