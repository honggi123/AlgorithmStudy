import java.io.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dwarf = mutableListOf<Int>()
    repeat(9) {
        dwarf.add(br.readLine().toInt())
    }

    val sum = dwarf.sum()
        
    loop@ for(i in 0..7){
      for(j in (i+1)..8){
          val spareSum = dwarf[i] + dwarf[j]
          val first = dwarf[i]
          val second = dwarf[j]

          if(sum - spareSum == 100){              
              dwarf.remove(first) 
              dwarf.remove(second)
              
              dwarf.sort()
              dwarf.forEach {
                  println(it.toString())
              }
              break@loop
          }
       }   
    }
}