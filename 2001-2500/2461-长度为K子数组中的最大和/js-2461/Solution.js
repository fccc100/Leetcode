/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumSubarraySum = function (nums, k) {
    let n = nums.length

    let l = 0
    let r = 0
    let curSum = 0
    let res = 0
    let map = new Map()
    for (; r < k; r++) {
        if (!map.has(nums[r])) {
            map.set(nums[r], 1)
        } else {
            map.set(nums[r], map.get(nums[r]) + 1)
        }
        curSum += nums[r]
    }
    r--

    if (map.size == k) {
        res = curSum
    }

    while (r + 1 < n) {
        r++
        curSum += nums[r]
        if (!map.has(nums[r])) {
            map.set(nums[r], 1)
        } else {
            map.set(nums[r], map.get(nums[r]) + 1)
        }

        map.set(nums[l], map.get(nums[l]) - 1)
        if (map.get(nums[l]) == 0) {
            map.delete(nums[l])
        }
        curSum -= nums[l]
        l++

        if (map.size == k) {
            res = Math.max(res, curSum)
        }
    }
    return res
}