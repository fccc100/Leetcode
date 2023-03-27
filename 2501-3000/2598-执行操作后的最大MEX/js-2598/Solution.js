/**
 * @param {number[]} nums
 * @param {number} value
 * @return {number}
 */
var findSmallestInteger = function (nums, value) {
    let n = nums.length
    for (let i = 0; i < n; i++) {
        nums[i] = (nums[i] + 10000000000 * value) % value
    }

    let map = new Map()
    for (let i = 0; i < n; i++) {
        if (map.has(nums[i])) {
            map.set(nums[i], map.get(nums[i]) + 1)
        } else {
            map.set(nums[i], 1)
        }
    }

    let cur = 0
    let res = 0
    while (true) {
        if (map.has(cur)) {
            res++
            map.set(cur, map.get(cur) - 1)
            if (map.get(cur) == 0) {
                map.delete(cur)
            }
            cur = (cur + 1) % value
        } else {
            return res
        }
    }
    return cur
};