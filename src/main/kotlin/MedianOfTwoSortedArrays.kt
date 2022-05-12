fun main() {
    println("Getting started")
    val a = intArrayOf(0,0,0,0,0)
    val b = intArrayOf(-1,0,0,0,0,0,1)
    val res = findMedianSortedArrays(a, b)
    println("Result is $res")
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val aSize = nums1.size
    val bSize = nums2.size
    var n = 0
    val testArray = mutableListOf<Int>()
    var lastNumber = 0
    var firstNumber = 0

    if (aSize != 0) {
        lastNumber = nums1[aSize - 1]
    }

    if (bSize != 0) {
        firstNumber = nums2[0]
    }

    if (lastNumber > firstNumber) {
        for (i in nums1.indices) {
            if (nums1[i] > firstNumber) {
                while (n < bSize && nums2[n] < nums1[i]) {
                    testArray.add(nums2[n])
                    n += 1
                }
                testArray.add(nums1[i])
            } else {
                testArray.add(nums1[i])
            }
        }
        if(n < bSize){
            val sub = nums2.slice(n until nums2.size)
            testArray.addAll(sub.toList())
        }
    } else {
        testArray.addAll(nums1.toList())
        testArray.addAll(nums2.toList())
    }
    return findMedian(aSize, bSize, testArray)
}

fun findMedian(aSize: Int, bSize: Int, testArray: List<Int>): Double {
    val arraySize = aSize + bSize
    val isEven = arraySize % 2 == 0
    var result: Double = 0.000
    if (testArray.isNotEmpty()) {
        result = if (isEven) {
            val mid = arraySize.toInt() / 2
            val res = (testArray[mid - 1] + testArray[mid]).toDouble() / 2
            res
        } else {
            val mid = arraySize.toInt() / 2
            println("mid is $mid")
            testArray[mid].toDouble()
        }
    }

    return result
}