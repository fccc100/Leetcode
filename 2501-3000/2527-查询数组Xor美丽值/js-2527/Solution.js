/**
 * @param {number[]} nums
 * @return {number}
 */
var xorBeauty = function(nums) {
    let res = 0
    for (let i = 0; i < nums.length; i++) {
        res ^= nums[i]
    }
    return res
};