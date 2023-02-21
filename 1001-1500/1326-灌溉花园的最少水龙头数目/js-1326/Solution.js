/**
 * @param {number} n
 * @param {number[]} ranges
 * @return {number}
 */
var minTaps = function(n, ranges) {
    let m = ranges.length
    let intervals = Array(m)
    for (let i = 0; i < m; i++) {
        let k = ranges[i]
        let l = Math.max(0, i - k)
        let r = Math.min(i + k, m - 1)
        intervals[i] = [l, r]
    }
    return solve(intervals, n)
};

function solve(intervals, n) {
    let m = intervals.length
    intervals.sort((a, b) => a[0] - b[0])

    let dp = Array(n + 1).fill(Infinity)
    dp[0] = 0
    for (let i = 0; i < m; i++) {
        let start = intervals[i][0]
        let end = intervals[i][1]

        if (dp[start] == Infinity) return -1

        for (let j = start; j <= end; j++) {
            dp[j] = Math.min(dp[j], dp[start] + 1);
        }
    }

    return dp[n] == Infinity ? -1 : dp[n]
}