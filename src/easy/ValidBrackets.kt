package easy

// https://leetcode.com/problems/valid-parentheses/description/


fun isValid(s: String): Boolean {
    val stack = java.util.Stack<Char>()
    for (i in s) {
        when (i) {
            '(' -> {
                stack.push(')')
            }
            '{' -> {
                stack.push('}')
            }
            '[' -> {
                stack.push(']')
            }
            else -> {
                if (stack.isEmpty()) return false
                val previous = stack.pop()
                if (previous != i) {
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    isValid("()[{]}").also { println(it) }
}