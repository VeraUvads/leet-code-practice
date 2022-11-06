package easy

// https://leetcode.com/problems/palindrome-number/description/

// convert to String
fun isPalindrome1(x: Int): Boolean {
    val string = x.toString()
    for (i in 0..string.length / 2) {
        if (string[i] != string[string.length - i - 1]) {
            return false
        }
    }
    return true
}

// accepted
// reverse half and compare
fun isPalindrome2(x: Int): Boolean {
    if (x == 0) return true
    if (x < 0 || x % 10 == 0) return false
    var n = x
    var reversed = 0
    while (reversed < n) {
        reversed = reversed * 10 + n % 10
        n /= 10
    }
    return n == reversed || n == reversed/10
}

fun main() {
    isPalindrome1(121)
    isPalindrome2(1221)
}