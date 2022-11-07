/**
 * @param {number[]} nums
 * @return {number[]}
 */
var applyOperations = function (nums) {
    let n = nums.length

    for (let i = 0; i < n - 1; i++) {
        if (nums[i] != nums[i + 1]) {
            continue;
        }
        nums[i] = 2 * nums[i]
        nums[i + 1] = 0
    }

    let res = []
    for (let i = 0; i < n; i++) {
        if (nums[i] != 0) {
            res.push(nums[i])
        }
    }
    for (let i = 0; i < n; i++) {
        if (nums[i] == 0) {
            res.push(0)
        }
    }

    return res;
};