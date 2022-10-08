/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let min = prices[0];
    let max = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > min) {
            max = Math.max(max, prices[i] - min);
        }
        min = Math.min(min, prices[i]);
    }
    return max;
};