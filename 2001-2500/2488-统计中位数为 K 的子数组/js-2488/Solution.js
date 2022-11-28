/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countSubarrays = function (nums, k) {
    let n = nums.length
    let kIdx = -1
    for (let i = 0; i < n; i++) {
        if (nums[i] == k) {
            kIdx = i
            break
        }
    }
    if (kIdx < 0) return 0

    let res = 1

    let leftMap = new Map()
    let min = 0, max = 0
    for (let i = kIdx - 1; i >= 0; i--) {
        if (nums[i] > k) {
            max++
        } else {
            min++
        }
        if (!leftMap.has(max - min)) {
            leftMap.set(max - min, 1)
        } else {
            leftMap.set(max - min, leftMap.get(max - min) + 1)
        }

        if (max == min || min == max - 1) {
            res++
        }
    }

    min = 0
    max = 0
    let rightMap = new Map()
    for (let i = kIdx + 1; i < n; i++) {
        if (nums[i] > k) {
            max++
        } else {
            min++
        }

        rightMap.set(i, max - min)
        if (max == min || min == max - 1) {
            res++
        }
    }

    for (let i = kIdx + 1; i < n; i++) {
        let cur = rightMap.get(i)
        if (leftMap.has(-cur)) {
            res += leftMap.get(-cur)
        }
        if (leftMap.has(1 - cur)) {
            res += leftMap.get(1 - cur)
        }
    }
    return res
};