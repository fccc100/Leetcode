/**
 * @param {number[]} nums
 * @return {number}
 */
var maxScore = function (nums) {
    let n = nums.length
    nums.sort((a, b) => b - a)
    let presum = nums[0]
    let res = 0
    if (presum > 0) res ++
    for (let i = 1; i < n; i++) {
        presum = presum + nums[i]
        if (presum > 0) res++
    }
    return res
};