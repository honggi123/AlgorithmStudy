fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val (n,m) = br.readLine().split(" ").map{ it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n+1){ 0 }
    var answerList: MutableList<Int> = mutableListOf()

    for(i in 1 .. n){
        dp[i] = dp[i-1] + arr[i-1]
    }
    
    repeat(m){
        val (start, end) = br.readLine().split(" ").map{it.toInt()}
        
        if(start == 1){
            answerList.add(dp[end])
        } else if(start == end){
            answerList.add(dp[end] - dp[end-1])
        } else {
            answerList.add(dp[end] - dp[start-1])
        }
    }
    
    answerList.forEach {
        bw.append("${it}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}