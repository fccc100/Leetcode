/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfGoodSubarraySplits = function (nums) {
    let n = nums.length
    let mod = 1000000007n

    let prev = -1
    let dis = []
    let cnt = 0
    for (let i = 0; i < n; i++) {
        if (prev == -1 && nums[i] == 0) continue
        if (nums[i] == 1) {
            cnt++
            if (prev != -1) {
                dis.push(BigInt(i - prev))
                prev = i
            } else {
                prev = i
            }
        }
    }
    if (cnt == 0) return 0
    if (cnt == 1) return 1
    let res = 1n
    for (let i = 0; i < dis.length; i++) {
        res = (res * dis[i]) % mod
    }
    return res % mod
};