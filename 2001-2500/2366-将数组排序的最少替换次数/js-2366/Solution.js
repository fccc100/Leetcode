/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumReplacement = function (nums) {
    let n = nums.length

    let next = nums[n - 1]
    let res = 0
    for (let i = n - 2; i >= 0; i--) {
        if (nums[i] > next) {
            let k = Math.ceil(nums[i] / last)
            res += k - 1
            last = Math.floor(nums[i] / k)
        } else {
            next = nums[i]
        }
    }
    return res
};