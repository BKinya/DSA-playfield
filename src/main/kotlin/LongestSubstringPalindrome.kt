fun main(){
    println("Longest Substring Palindrome")
   val res = longestPalindrome("abcdefghijklmnopqrstuvwxyz")
    println("res => $res")
}

fun longestPalindrome(s: String): String {
    if (s == null || s == ""){
        return s
    }
    var start = 0
    var end = 0
    for ( i in s.indices){
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i+1)
        val res = Math.max(len1, len2)
        if (res > (end - start) ){
            start = i - (res - 1) / 2
            end = i + res / 2
        }
    }

    return s.substring(start, end + 1)
}

fun expandAroundCenter(s: String, left: Int, right: Int): Int{
    var l = left
    var r = right

    while ( l>=0 && r < s.length && (s[l] == s[r])){
        l -= 1
        r += 1
    }

    return r  - l - 1
}