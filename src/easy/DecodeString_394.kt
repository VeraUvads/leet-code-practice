package easy

import java.util.*


class DecodeString_394 {
    // https://leetcode.com/problems/decode-string/description/?envType=study-plan&id=level-1
    fun decodeString(s: String): String {
        var helper = StringBuilder()
        val numbersStack = Stack<Int>()
        val stringStack = Stack<StringBuilder>()
        var k = 0

        for (char in s) {
            when (char) {
                in 'a'..'z' -> {
                    helper.append(char)
                }
                '[' -> {
                    numbersStack.add(k)
                    k = 0
                }
                ']' -> {
                    if (helper.isNotEmpty())  {
                        stringStack.add(helper)
                        helper = StringBuilder()
                    }
                    val currentMultiplier = numbersStack.pop()
                    val currentString = stringStack.pop().repeat(currentMultiplier)
                    if (stringStack.isEmpty()) {
                        stringStack.add(StringBuilder(currentString))
                    } else {
                        stringStack.add(stringStack.pop().append(currentString))
                    }
                }
                else -> {
                    k = k * 10 + char.toString().toInt()
                    if (helper.isNotEmpty())  {
                        stringStack.add(helper)
                        helper = StringBuilder()
                    }
                }
            }
        }
        if (helper.isNotEmpty())  {
            stringStack.add(stringStack.pop().append(helper))
        }
        return stringStack.pop().toString()
    }
}

fun main() {
    DecodeString_394().decodeString("2[abc]3[cd]ef")
}