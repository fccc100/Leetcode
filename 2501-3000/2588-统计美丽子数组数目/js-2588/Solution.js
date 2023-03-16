/**
 * @param {number[]} nums
 * @return {number}
 */
var beautifulSubarrays = function (nums) {
    let n = nums.length

    let res = 0
    let pre = Array(n + 1).fill(0)

    for (let i = 1; i <= n; i++) {
        pre[i] = pre[i - 1] ^ nums[i - 1]
    }
    let map = new Map()

    for (let i = 0; i <= n; i++) {
        if (map.has(pre[i])) {
            res += map.get(pre[i])
            map.set(pre[i], map.get(pre[i]) + 1)
        } else {
            map.set(pre[i], 1)
        }
    }


    return res
};