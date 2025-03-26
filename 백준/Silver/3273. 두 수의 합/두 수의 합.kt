fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    val target = br.readLine().toInt()
    
    arr.sort()
    var left = 0
    var right = arr.size - 1
    var cnt = 0
    
    while(left < right){
        val sum = arr[left] + arr[right]
        when {
            sum == target -> { 
                cnt++ 
                left++             
            }
            sum < target -> left++
            else -> right--
        }
    }
    
    bw.write("$cnt")
    bw.flush()
    bw.close()
    br.close()
}