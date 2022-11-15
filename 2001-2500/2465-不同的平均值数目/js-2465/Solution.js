/**
 * @param {number[]} nums
 * @return {number}
 */
var distinctAverages = function (nums) {
    let set = new Set()

    nums.sort((a, b) => a - b)
    while (nums.length > 0) {
        let min = nums.shift()
        let max = nums.pop()
        set.add((min + max) / 2)
    }
    return set.size
};