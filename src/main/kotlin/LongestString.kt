fun main() {
    val res = lengthOfLongestSubstring("pwwkew")
    println("Result is $res")
}

fun lengthOfLongestSubstring(s: String): Int {
    if ( s == null || s.length == 0){
        return 0
    }
    var i = 0
    var j = 0
    var max = 0
    val aSet = mutableSetOf<Char>()
    while (i < s.length){
        val char = s[i]
        while(aSet.contains(char)){
            aSet.remove(s[j])
            j += 1
        }
        aSet.add(char)
        max = Math.max(max, i - j + 1)
        i += 1
    }
    return max

}

