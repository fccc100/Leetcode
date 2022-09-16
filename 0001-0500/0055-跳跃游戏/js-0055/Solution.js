/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let n = nums.length;
    let dp = Array(n).fill(0);

    dp[0] = nums[0];
    for (let i = 1; i < n; i++) {
      if (dp[i - 1] < i) {
        return false;
      }

      dp[i] = Math.max(dp[i - 1], i + nums[i]);
    }
    return true;
};