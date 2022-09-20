/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumbers = function(nums) {
    let n = nums.length;

    let map = new Map();
    for (let i = 0; i < n; i++) {
        if (!map.has(nums[i])) {
            map.set(nums[i], 1);
        } else {
            map.set(nums[i], map.get(nums[i]) + 1);
        }
    }

    let res = [];
    for (let [key, val] of map) {
        if (val == 1) {
            res.push(key);
        }
    }
    return res;
};