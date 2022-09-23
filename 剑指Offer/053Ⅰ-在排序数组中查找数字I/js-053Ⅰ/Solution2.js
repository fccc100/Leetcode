/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let lowerIdx = lower(nums, target);
    let upperIdx = upper(nums, target);

    return upperIdx - lowerIdx - 1;
};

// 查询小于target的最大值的索引
function lower(nums, target) {
    let l = -1;
    let r = nums.length - 1;

    while (l < r) {
        let mid = l + ((r - l + 1) >> 1);

        if (nums[mid] < target) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return l;
}

// 查询大于target的最小值的索引
function upper(nums, target) {
    let l = 0;
    let r = nums.length;

    while (l < r) {
        let mid = l + (r - l >> 1);

        if (nums[mid] > target) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}