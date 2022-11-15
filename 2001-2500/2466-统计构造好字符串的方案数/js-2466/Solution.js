/**
 * @param {number} low
 * @param {number} high
 * @param {number} zero
 * @param {number} one
 * @return {number}
 */
var countGoodStrings = function (low, high, zero, one) {
    let mod = 1e9 + 7

    let dp = Array(high + 1).fill(0)
    dp[0] = 1

    for (let i = 1; i <= high; i++) {
        if (i >= zero) {
            dp[i] += dp[i - zero]
        }
        if (i >= one) {
            dp[i] += dp[i - one]
        }

        dp[i] %= mod
    }

    let res = 0
    for (let i = low; i <= high; i++) {
        res = (res + dp[i]) % mod
    }
    return res
};