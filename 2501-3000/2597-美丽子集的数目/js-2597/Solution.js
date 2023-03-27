/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var beautifulSubsets = function (nums, k) {
    let res = 0
    function _subsets(nums, index, path) {
        res++
        if (index == nums.length) return;

        for (let i = index; i < nums.length; i++) {
            if (path.includes(nums[i] - k)  || path.includes(nums[i] + k)) continue
            path.push(nums[i]);
            _subsets(nums, i + 1, path);
            path.pop();
        }
    }
    _subsets(nums, 0, [])

    return res - 1
};