/**
 * @param {number[]} nums
 * @return {number}
 */
var maxNumOfMarkedIndices = function(nums) {
    let n = nums.length
    nums.sort((a, b) => a - b)

    let l = 0
    let r = n >> 1
    while (l < r) {
        let mid = l + (r - l + 1 >> 1)
        if (check(nums, mid)) {
            l = mid
        } else {
            r = mid - 1
        }
    }
    return l * 2
};

function check(nums, k) {
    let l = 0
    let r = nums.length - k
    while (k > 0) {
        if (nums[l] * 2 > nums[r]) return false
        l++
        r++
        k--
    }
    return true
}