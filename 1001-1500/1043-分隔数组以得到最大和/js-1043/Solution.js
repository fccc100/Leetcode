/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function(arr, k) {
    let n = arr.length

    // dp[i]: 前i个数的分割最大值
    let dp = Array(n + 1).fill(0)
    for (let i = 1; i <= n; i++) {
        let max = -Infinity
        for (let j = i - 1; j >= Math.max(0, i - k); j--) {
            max = Math.max(max, arr[j])
            dp[i] = Math.max(dp[i], dp[j] + (i - j) * max)
        }
    }
    return dp[n]
};
