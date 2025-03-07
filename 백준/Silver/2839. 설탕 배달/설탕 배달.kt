fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    val a = n / 5
    
    for(i in a downTo 0){
        var remain = n - (i * 5)
        if(remain % 3 == 0){
            var bags = remain / 3 + i
            list.add(bags)
        }
    }
    
    if(list.isEmpty()){
        bw.append("-1")
    } else {
        bw.append("${list.min()}")
    }
    
    bw.flush()
    bw.close()
    br.close()
}