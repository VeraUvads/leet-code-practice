package easy

import java.lang.IllegalStateException

// https://leetcode.com/problems/roman-to-integer/


// FIRST WAY
fun romanToInt1(s: String): Int {
    var result = 0
    var previousSymbol = s[0]
    for (i in 1 until s.length) {
        val currentSymbol = s[i]
        when {
            (currentSymbol == 'V' || currentSymbol == 'X') && previousSymbol == 'I' ||
                    (currentSymbol == 'L' || currentSymbol == 'C') && previousSymbol == 'X' ||
                    (currentSymbol == 'M' || currentSymbol == 'D') && previousSymbol == 'C' -> {
                val currentNumber = 0 - getIntBySymbol(previousSymbol)
                result += currentNumber
            }
            else -> {
                result += getIntBySymbol(previousSymbol)
            }
        }
        previousSymbol = currentSymbol
    }
    return result + getIntBySymbol(previousSymbol)
}

fun getIntBySymbol(char: Char): Int {
    return when (char) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> throw IllegalStateException()
    }
}

// SECOND WAY (Better)
fun romanToInt(s: String): Int {
    val map = mutableMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
    var result = 0
    var previousNumber = map[s[0]]!!
    for (i in 1 until s.length) {
        val currentNumber = map[s[i]]!!
        when {
            currentNumber > previousNumber -> result -= previousNumber
            else -> result += previousNumber
        }
        previousNumber = currentNumber
    }
    return result + previousNumber
}


fun main() {
    romanToInt("IV").also { println(it) }
    romanToInt("VII").also { println(it) }
    romanToInt("III").also { println(it) }
    romanToInt("LVIII").also { println(it) }
    romanToInt("MCMXCIV").also { println(it) }
}