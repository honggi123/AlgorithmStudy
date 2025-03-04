fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    var (n, k) = br.readLine().split(" ").map{ it.toInt() }
    var coins = IntArray(n) { br.readLine().toInt() }
    var answer = 0
    
    for(i in coins.size -1 downTo 0){
        if(k < coins[i]) continue
        answer += k / coins[i]
        k = k % coins[i]    
    }
    bw.append("${answer}")
    bw.flush()
    bw.close()
    br.close()
    
}