/**
 * @param {number[]} nums
 * @param {number[]} queries
 * @return {number[]}
 */
var minOperations = function (nums, queries) {
    let m = nums.length
    let n = queries.length

    nums.sort((a, b) => a - b)
    let presum = Array(m + 1).fill(0)

    for (let i = 1; i <= m; i++) {
        presum[i] = presum[i - 1] + nums[i - 1]
    }

    let res = Array(n).fill(0)
    for (let i = 0; i < n; i++) {

        // 查询小于等于queries[i]的最大值
        let idx = upper_floor(nums, queries[i])

        let lowsum = presum[idx + 1]
        let gratesum = presum[m] - presum[idx + 1]

        res[i] = ((queries[i] * (idx + 1)) - lowsum) + (gratesum - (queries[i] * (m - idx - 1)))
    }
    return res
};

function upper_floor(nums, target) {
    let l = -1;
    let r = nums.length - 1;
    while (l < r) {
        let mid = l + (r - l + 1 >> 1);
        if (nums[mid] <= target) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return l;
}