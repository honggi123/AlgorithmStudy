fun main(){
   val br = System.`in`.bufferedReader()
   val bw = System.out.bufferedWriter()
      
   var sum = 0L
   val num = br.readLine().toInt()
   var lengthArray = br.readLine().split(" ").map{ it.toLong() }
   val priceArray = br.readLine().split(" ").map{ it.toLong() }
   var minPrice = priceArray[0]
       
   priceArray.forEachIndexed { index, price ->
       if(price < minPrice){
           minPrice = price
       }
       if(index <= lengthArray.size-1){
           sum += minPrice * lengthArray[index]                
       }                    
   }
   bw.append("${sum}")
   bw.flush()
   bw.close()
}