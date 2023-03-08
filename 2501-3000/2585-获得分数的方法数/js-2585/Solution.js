/**
 * @param {number} target
 * @param {number[][]} types
 * @return {number}
 */
var waysToReachTarget = function (target, types) {
    let n = types.length
    let mod = 1000000007

    // dp[i][j]前i题拿j分
    let dp = Array(n + 1)
    for (let i = 0; i <= n; i++) {
        dp[i] = Array(target + 1).fill(0)
    }

    for (let i = 1; i <= n; i++) {
        let type = types[i - 1]
        let c = type[0]
        let m = type[1]

        for (let j = 0; j <= c; j++) {
            let score = j * m

            for (let k = 0; k <= target; k++) {
                if (score == k) {
                    dp[i][k] = (dp[i][k] + 1) % mod
                }
                if (score < k) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - score]) % mod
                }
            }
        }
    }
    return dp[n][target] % mod
};