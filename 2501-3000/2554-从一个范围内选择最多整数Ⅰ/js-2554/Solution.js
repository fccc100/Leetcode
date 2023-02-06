/**
 * @param {number[]} banned
 * @param {number} n
 * @param {number} maxSum
 * @return {number}
 */
var maxCount = function (banned, n, maxSum) {
    let m = banned.length
    let set = new Set()
    for (let i = 0; i < m; i++) {
        set.add(banned[i])
    }

    let sum = 0
    let res = 0
    for (let i = 1; i <= n; i++) {
        if (!set.has(i)) {
            sum += i
            if (sum > maxSum) return res
            res++
        }
    }
    return res
};