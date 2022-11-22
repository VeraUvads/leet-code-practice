package easy

class BestTimeToBuyAndSellStock_121 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Integer.MAX_VALUE
        var maxProfit = 0
        for (i in prices) {
            if (i < minPrice) {
                minPrice = i
            }
            if (i - minPrice > maxProfit) {
                maxProfit = i - minPrice
            }
        }
        return maxProfit
    }

}