/**
 * @param {number[]} nums
 * @return {number[]}
 */
// 先排序再求两个数字 O(nlogn)
var missingTwo = function (nums) {
    let n = nums.length;
    nums.sort((a, b) => a - b);

    let first = -1;
    let curSum = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1 && first < 0) {
            first = i + 1;
        }

        curSum += nums[i];
    }

    if (first < 0) {
        return [nums[n - 1] + 1, nums[n - 1] + 2];
    }

    let sum = (n + 2) * (1 + n + 2) / 2;
    return [first, sum - curSum - first];
};