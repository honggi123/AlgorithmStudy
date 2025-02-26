import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
   val maxSize: Int = 10001
   val cntArr = IntArray(maxSize) { 0 }
   val br = BufferedReader(InputStreamReader(System.`in`)) 
   val n = br.readLine().toInt()
    
   for(i in 0 until n){
      val num = br.readLine().toInt()
      cntArr[num]++
   }
    
   val bufferWriter = System.out.bufferedWriter()
   for(i in 1 until maxSize) {
       repeat(cntArr[i]){
           bufferWriter.write(i.toString())
           bufferWriter.write("\n")
       }
   } 
   bufferWriter.flush()
   bufferWriter.close()
}