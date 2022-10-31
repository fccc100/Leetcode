/**
 * @param {number[]} nums
 * @return {number}
 */
var averageValue = function (nums) {
    let n = nums.length

    let cnt = 0
    let sum = 0
    for (let i = 0; i < n; i++) {
        if (nums[i] % 3 == 0 && nums[i] % 2 == 0) {
            sum += nums[i]
            cnt++
        }
    }

    return cnt == 0 ? 0 : Math.floor(sum / cnt)
}