/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeightII = function (stones) {
    let n = stones.length

    let sum = 0
    for (let x of stones) sum += x

    let c = sum >> 1

    // stones放入容量为c的背包，最多能放多少
    // dp[i][j]: 前i个石头放入容量为j的背包最多能放多少
    let dp = Array(n + 1)
    for (let i = 0; i <= n; i++) {
        dp[i] = Array(c + 1).fill(0)
    }

    for (let i = 1; i <= n; i++) {
        let w = stones[i - 1]
        for (let j = 1; j <= c; j++) {
            dp[i][j] = dp[i - 1][j]
            if (w <= j) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + w)
            }
        }
    }

    return sum - 2 * dp[n][c]
}