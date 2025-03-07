fun main(){
   val br = System.`in`.bufferedReader()
   val bw = System.out.bufferedWriter()
    
   val n = br.readLine().toInt()
   val list = br.readLine().split(" ").map{ it.toInt() }
   val map = HashMap<Int,Int>()
   var cnt = 0
   val sortedList = list.distinct().sorted()

   sortedList.forEach {
        map.put(it,cnt++)  
   }

   list.forEach{
       bw.append("${map[it]} ") 
   }
    
   bw.flush()
   bw.close()
   br.close()
}