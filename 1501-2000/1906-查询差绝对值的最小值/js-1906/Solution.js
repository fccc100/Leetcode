/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var minDifference = function (nums, queries) {
    let n = nums.length

    // precnt[i][j] nums前i个元素含有j的个数
    let precnt = Array(n + 1)
    for (let i = 0; i <= n; i++) {
        precnt[i] = Array(101).fill(0)
    }

    // 计算前i个元素中含有j的个数
    for (let i = 1; i <= n; i++) {
        for (let j = 0; j <= 100; j++) {
            precnt[i][j] = precnt[i - 1][j]
        }
        precnt[i][nums[i - 1]]++
    }

    // 对每个区间[l, r], 根据前缀和相减是否大于0判断这个区间是否包含j
    // 最小的绝对值一定是所有相邻元素绝对值的最小值
    let res = Array(queries.length).fill(0)
    for (let i = 0; i < queries.length; i++) {
        let l = queries[i][0]
        let r = queries[i][1]

        let prev = -1;
        let cur = Infinity
        for (let j = 1; j <= 100; j++) {
            if (precnt[r + 1][j] - precnt[l][j] > 0) {
                if (prev == -1) {
                    prev = j
                } else {
                    cur = Math.min(cur, j - prev)
                    prev = j
                }
            }
        }
        res[i] = cur == Infinity ? -1 : cur
    }
    return res
};