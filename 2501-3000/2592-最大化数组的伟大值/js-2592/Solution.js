/**
 * @param {number[]} nums
 * @return {number}
 */
var maximizeGreatness = function (nums) {
    let n = nums.length
    let t = nums.slice()
    nums.sort((a, b) => b - a)
    t.sort((a, b) => b - a)

    let res = 0
    let i = 0
    let j = 0
    while (i < n && j < n) {
        if (t[i] > nums[j]) {
            res++
            i++
            j++
        } else {
            j++
        }
    }
    return res
};