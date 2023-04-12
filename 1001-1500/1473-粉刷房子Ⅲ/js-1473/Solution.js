/**
 * @param {number[]} houses
 * @param {number[][]} cost
 * @param {number} m
 * @param {number} n
 * @param {number} target
 * @return {number}
 */
var minCost = function (houses, cost, m, n, target) {

    let memo = Array(m)
    for (let i = 0; i < m; i++) {
        memo[i] = Array(n + 1)
        for (let j = 0; j <= n; j++) {
            memo[i][j] = Array(target + 1).fill(-1)
        }
    }

    // 第idx个房子涂colorIdx种颜色生成streetCnt个街区的最小花费
    function dfs(idx, colorIdx, streetCnt) {
        if (idx < 0) return 0
        if (streetCnt <= 0) return Infinity
        if (idx + 1 < streetCnt) return Infinity

        if (memo[idx][colorIdx][streetCnt] != -1) {
            return memo[idx][colorIdx][streetCnt]
        }

        let curCost = houses[idx] == 0 ? cost[idx][colorIdx - 1] : 0
        let res = Infinity

        let next = idx - 1
        if (next < 0) return memo[idx][colorIdx][streetCnt] = curCost
        if (houses[next] != 0) {
            if (houses[next] == colorIdx) {
                res = Math.min(res, dfs(next, houses[next], streetCnt))
            } else {
                res = Math.min(res, dfs(next, houses[next], streetCnt - 1))
            }
        } else {
            for (let i = 0; i < n; i++) {
                if (i + 1 != colorIdx) {
                    res = Math.min(res, dfs(next, i + 1, streetCnt - 1))
                } else {
                    res = Math.min(res, dfs(next, i + 1, streetCnt))
                }
            }
        }

        return memo[idx][colorIdx][streetCnt] = curCost + res
    }


    if (houses[m - 1] != 0) {
        let res = dfs(m - 1, houses[m - 1], target)
        return res == Infinity ? -1 : res
    }

    let res = Infinity
    for (let i = 0; i < n; i++) {
        res = Math.min(res, dfs(m - 1, i + 1, target))
    }
    return res == Infinity ? -1 : res
};