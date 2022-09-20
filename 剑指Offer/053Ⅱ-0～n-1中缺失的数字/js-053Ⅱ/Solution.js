/**
 * @param {number[]} nums
 * @return {number}
 */
// 等差数列求和公式
var missingNumber = function(nums) {
    let n = nums.length;

    let sum = (n + 1) * (0 + n) / 2;

    let curSum = 0;
    for (let i = 0; i < n; i++) {
        curSum += nums[i];
    }

    return sum - curSum;
};