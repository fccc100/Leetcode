/**
 * @param {string} s
 * @param {string} chars
 * @param {number[]} vals
 * @return {number}
 */
var maximumCostSubstring = function (s, chars, vals) {
    let n = s.length

    let map = Array(26).fill(-10000)
    for (let i = 0; i < chars.length; i++) {
        let c = chars[i]
        map[c.charCodeAt() - 'a'.charCodeAt()] = vals[i]
    }

    let res = 0
    let dp = Array(n + 1).fill(0)
    for (let i = 1; i <= s.length; i++) {
        let c = s[i - 1]
        let v = map[c.charCodeAt() - 'a'.charCodeAt()]
        if (v > -10000) {
            dp[i] = Math.max(dp[i - 1] + v, v)
        } else {
            v = c.charCodeAt() - 'a'.charCodeAt() + 1
            dp[i] = Math.max(dp[i - 1] + v, v)
        }
        res = Math.max(res, dp[i])
    }
    return res
};