fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
        
    val n = br.readLine().toInt()
    val stringSet = mutableSetOf<String>() 
    val wordSet = mutableSetOf<Pair<Int,String>>()  
        
    repeat(n){
       val s = br.readLine().toString()
       stringSet.add(s) 
    }    
    stringSet.forEach {
        wordSet.add(Pair(it.length,it))
    }
    val sortedSet = wordSet.sortedWith(compareBy({ it.first },{ it.second }))
    
    sortedSet.forEach{
       bw.append("${it.second}\n")
    }    
    bw.flush()
    bw.close()
    br.close()    
}