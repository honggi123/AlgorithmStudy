fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
        
    val n = br.readLine().toInt()
    val stringSet = mutableSetOf<String>() 
        
    repeat(n){
       val s = br.readLine().toString()
       stringSet.add(s) 
    }    

    val sortedSet = stringSet.sortedWith(compareBy({ it.length },{ it }))
    
    sortedSet.forEach{
       bw.append("${it}\n")
    }    
    bw.flush()
    bw.close()
    br.close()    
}