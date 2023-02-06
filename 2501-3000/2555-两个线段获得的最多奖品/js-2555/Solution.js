/**
 * @param {number[]} prizePositions
 * @param {number} k
 * @return {number}
 */
var maximizeWin = function (prizePositions, k) {
    let n = prizePositions.length
    let dp = Array(n + 1).fill(0)
    for (let i = n - 1; i >= 0; i--) {
        dp[i] = dp[i + 1]
        let cur = lower(prizePositions, prizePositions[i] + k + 1) + 1
        dp[i] = Math.max(dp[i], cur - i)
    }

    let res = 0
    for (let i = 0; i < n; i++) {
        let cur = lower(prizePositions, prizePositions[i] + k + 1) + 1
        res = Math.max(res, cur - i + dp[cur])
    }
    return res
};

function lower(nums, target) {
    let l = -1;
    let r = nums.length - 1;
    while (l < r) {
        let mid = l + (r - l + 1 >> 1);
        if (nums[mid] >= target) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    return l;
}