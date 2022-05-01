fun main() {
    println("Minimum Erase Value is ")
    val nums = intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)
    val res = maximumUniqueSubarray(nums)
    println("Result is $res")
}

fun maximumUniqueSubarray(nums: IntArray): Int {
    var i = 0
    var j = 0
    var max = 0
    var newSum = 0
    val aSet = mutableSetOf<Int>()
    while (i < nums.size) {
        val num = nums[i]
        while (aSet.contains(num)) {
            aSet.remove(nums[j])
            newSum -= nums[j]
            j += 1
        }
        aSet.add(num)
        newSum += num
        max = Math.max(max, newSum)
        i += 1
    }

    return max

}