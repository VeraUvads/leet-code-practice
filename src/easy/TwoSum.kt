package easy

// https://leetcode.com/problems/two-sum/description/
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        val diff = target - nums[i];
        if (map.contains(diff)) {
            return intArrayOf(map[diff]!!, i)
        } else {
            map[nums[i]] = i
        }
    }
    return intArrayOf()
}

fun main() {
    twoSum(intArrayOf(3, 2, 4), 6)
}