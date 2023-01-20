/**
 * @param {number[]} nums
 * @return {number}
 */
var differenceOfSum = function (nums) {
    let n = nums.length
    let sum1 = 0
    let sum2 = 0
    for (let i = 0; i < n; i++) {
        sum1 += nums[i]
        let cur = nums[i] + ''
        let curSum = 0
        for (let j = 0; j < cur.length; j++) {
            curSum += Number(cur[j])
        }
        sum2 += curSum
    }
    return Math.abs(sum1 - sum2)
};