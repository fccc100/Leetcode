/**
 * @param {number[]} nums
 * @return {number[]}
 */
var leftRigthDifference = function (nums) {
    let n = nums.length
    let lS = Array(n)
    let rS = Array(n)
    lS[0] = nums[0]
    for (let i = 1; i < n; i++) {
        lS[i] = lS[i - 1] + nums[i]
    }
    rS[n - 1] = nums[n - 1]
    for (let i = n - 2; i >= 0; i--) {
        rS[i] = rS[i + 1] + nums[i]
    }

    let res = Array(n)
    for (let i = 0; i < n; i++) {
        res[i] = Math.abs(lS[i] - rS[i])
    }
    return res
};