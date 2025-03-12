import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val n = br.readLine().toInt()
    repeat(n){
        val s = br.readLine()
        val stack = Stack<Char>()
        
        s.forEach{ comp ->
            if(comp == '('){
                stack.push(comp)
            } else if(comp == ')'){
                if(stack.size == 0){
                    bw.write("NO\n")
                    return@repeat
                }
                val comp2 = stack.pop()
                if(comp2 == ')'){
                    bw.write("NO\n")
                    return@repeat 
                }
            }
         }
        if(stack.isEmpty()){
            bw.write("YES\n")
        }else{
            bw.write("NO\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}