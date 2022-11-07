package easy

// Using sorting
// complexity O(nLog(n)) + O(m);  space O(1)
fun longestCommonPrefix(strs: Array<String>): String {
    strs.sort()
    var i = 0;
    val first = strs[0]
    val last = strs[strs.size - 1]
    while (i < Math.min(first.length, last.length) && first[i] == last[i]) {
        i++
    }
    return first.substring(0, i)
}

// Take the first string as a prefix and gradually reduce the length of the prefix
// complexity O(n*m);  space O(1)
fun longestCommonPrefix2(strs: Array<String>): String {
    var prefix = strs[0]
    for (i in 0..strs.size) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isBlank()) return ""
        }
    }
    return prefix
}

