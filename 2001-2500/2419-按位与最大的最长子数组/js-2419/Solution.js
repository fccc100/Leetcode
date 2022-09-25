/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function (nums) {
    let max = nums[0]

    for (let i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
    }

    let res = 0;
    let curLen = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == max) {
            curLen++;
        } else {
            curLen = 0;
        }
        res = Math.max(curLen, res);
    }
    return res;
};