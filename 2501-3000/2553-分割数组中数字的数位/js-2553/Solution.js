/**
 * @param {number[]} nums
 * @return {number[]}
 */
var separateDigits = function (nums) {
    let res = []
    for (let i = 0; i < nums.length; i++) {
        let s = String(nums[i])
        for (let j = 0; j < s.length; j++) {
            res.push(Number(s[j]))
        }
    }
    return res
};