fun main() {
    println("Return number of good sub arrays")
    val array = intArrayOf(1, 2, 1, 2, 3)
    val res = subarraysWithKDistinct(array, 3)
    println("RESULT IS $res")
}

//  Don't seem to wrap my mind arounf this. I'll look at some other time.
fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    val upperOccurences = findOcurrences(nums, k)
    println("UPPER $upperOccurences")
    val lowerOccurences = findOcurrences(nums, k - 1)
    println("lower $lowerOccurences")
    return upperOccurences - lowerOccurences
}

fun findOcurrences(nums: IntArray, k: Int): Int {
    var i = 0
    var j = 0
    var occurences = 0
    val subArray = mutableListOf<Int>()
    var map = mutableMapOf<Int, Int>()
    while (i < nums.size) {
        val num = nums[i]
        if (map.containsKey(num)) {
            val old = map[num]!!
            map[num] = old + 1
        }
        map[num] = 1
        subArray.add(num)

        occurences += subArray.size
        i += 1
        while (map.size == k) {
            val num2 = nums[j]
            val old = map[num2]!!
            map[num2] = old - 1
            if (map[num2] == 0) {
                map.remove(num2)
                subArray.remove(num2)
            }
            j += 1
        }

    }
    return occurences
}

