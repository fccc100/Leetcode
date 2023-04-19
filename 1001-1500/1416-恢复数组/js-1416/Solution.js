/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var numberOfArrays = function (s, k) {
    let n = s.length
    let MOD = 1000000007

    // dp[i]: 前i个字符的方案数
    let dp = Array(n + 1).fill(0)
    dp[0] = 1
    for (let i = 1; i <= n; i++) {
        let cur = 0
        let d = 1
        for (let j = i - 1; j >= 0; j--) {
            if (i - j > 10) break
            if (s[j] != 0) {
                cur = Number(s[j]) * d + cur
                if (cur > k) break
                dp[i] = (dp[i] + dp[j]) % MOD
            }
            d *= 10
        }
    }
    return dp[n]
};
