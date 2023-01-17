/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countGood = function (nums, k) {
    let n = nums.length
    if (n <= 1) return 0
    let l = 0
    let r = 1
    let cnt = nums[0] == nums[1] ? 1 : 0
    let map = new Map()
    if (nums[0] == nums[1]) {
        map.set(nums[0], 2)
    } else {
        map.set(nums[0], 1)
        map.set(nums[1], 1)
    }
    let res = 0
    while (l < n && r < n) {

        if (cnt < k) {
            r++
            if (r >= n) break
            let preCnt = map.get(nums[r]) || 0
            cnt += preCnt
            map.set(nums[r], (map.get(nums[r]) || 0) + 1)
        } else {
            res += n - r
            map.set(nums[l], map.get(nums[l]) - 1)
            if (map.get(nums[l]) == 0) {
                map.delete(nums[l])
            }
            let c = map.get(nums[l]) || 0
            l++
            cnt -= c
        }
    }
    return res
};