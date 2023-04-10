/**
 * @param {number[][]} fruits
 * @param {number} startPos
 * @param {number} k
 * @return {number}
 */
var maxTotalFruits = function (fruits, startPos, k) {
    let n = fruits.length
    let max = Math.max(fruits[n - 1][0], startPos)
    let nums = Array(max + 1).fill(0)
    for (let i = 0; i < n; i++) {
        nums[fruits[i][0]] += fruits[i][1]
    }

    let presum = Array(nums.length + 1).fill(0)
    for (let i = 1; i < presum.length; i++) {
        presum[i] = presum[i - 1] + nums[i - 1]
    }

    let res = 0
    for (let i = 0; i <= startPos; i++) {
        let leftDis = startPos - i
        if (leftDis > k) continue

        // 第一种情况：折返左边部分
        let left = k - (2 * leftDis)
        let maxRight = Math.min(max, startPos + left)
        res = Math.max(res, presum[maxRight + 1] - presum[i])

        // 第二种情况：折返右边部分
        let maxRight2 = Math.min(max, startPos + Math.floor((k - leftDis) / 2))
        res = Math.max(res, presum[maxRight2 + 1] - presum[i])
    }
    return res
};