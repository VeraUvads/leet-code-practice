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
                    stringStack.add(helper)
                    helper = StringBuilder()
                    k = 0
                }
                ']' -> {
                    val decodedString = stringStack.pop();
                    for (i in numbersStack.pop() downTo 1) {
                        decodedString.append(helper);
                    }
                    helper = decodedString;
                }
                else -> {
                    k = k * 10 + char.toString().toInt()
                }
            }
        }
        if (helper.isNotEmpty())  {
            if (stringStack.isNotEmpty()) {
                stringStack.add(stringStack.pop().append(helper))
            } else{
                return helper.toString()
            }
        }
        return stringStack.pop().toString()
    }
}

fun main() {
    DecodeString_394().decodeString("2[abc]3[cd]ef")
}