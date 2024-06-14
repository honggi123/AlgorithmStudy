fun main(){
    val num1 = readLine()!!.toInt()
    var arr1 = readLine()!!.split(" ").map{it.toInt()}
    val num2 = readLine()!!.toInt()
    val arr2 = readLine()!!.split(" ").map{it.toInt()}
    arr1 = arr1.sorted().toMutableList()

    for(i in 0 until num2){
        var find = arr2[i]
        var ans = binarySearch(arr1,find)
        println(ans)
    }
}

fun binarySearch(list: List<Int>, target: Int): Int {
    var start = 0
    var end = list.size - 1
    
    while(start <= end){
        var pivot = (start + end)/2
        
        if(list.get(pivot) == target) return 1
        else if(list.get(pivot) > target) end = pivot - 1 
        else start = pivot + 1
    }
    return 0
}