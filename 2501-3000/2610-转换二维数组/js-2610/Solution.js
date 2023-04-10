/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findMatrix = function (nums) {
    let n = nums.length

    let map = new Map()
    let max = 0
    for (let i = 0; i < n; i++) {
        if (!map.has(nums[i])) {
            map.set(nums[i], 1)
        } else {
            map.set(nums[i], map.get(nums[i]) + 1)
        }
        max = Math.max(max, map.get(nums[i]))
    }

    let res = []
    for (let i = 0; i < max; i++) {
        let cur = []
        for (let entry of map.entries()) {
            cur.push(entry[0])
            map.set(entry[0], entry[1] - 1)
            if (map.get(entry[0]) == 0) {
                map.delete(entry[0])
            }
        }
        res.push(cur)
    }
    return res
};