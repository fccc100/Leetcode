/**
 * @param {number[]} nums
 * @param {number[]} multipliers
 * @return {number}
 */
var maximumScore = function (nums, multipliers) {
    let n = nums.length
    let m = multipliers.length

    // dp[i][j]: 前面取i个后面取j个的最大分数
    let dp = Array(m + 1)
    for (let i = 0; i <= m; i++) {
        dp[i] = Array(m + 1).fill(0)
    }

    let res = -Infinity
    for (let k = 1; k <= m; k++) {
        for (let i = 0; i <= k; i++) {
            let j = k - i
            if (i == 0) {
                dp[i][j] = dp[i][j - 1] + nums[n - j] * multipliers[k - 1]
            } else if (i == k) {
                dp[i][j] = dp[i - 1][j] + nums[k - 1] * multipliers[k - 1]
            } else {
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[k - 1], dp[i][j - 1] + nums[n - j] * multipliers[k - 1])
            }
            if (k == m) {
                res = Math.max(res, dp[i][j])
            }
        }
    }
    return res
}
