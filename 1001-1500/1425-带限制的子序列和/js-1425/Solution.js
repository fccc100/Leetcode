/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var constrainedSubsetSum = function(nums, k) {
    let n = nums.length;
    if (n == 0) return 0;

    let dp = Array(n).fill(0);
    dp[0] = nums[0];

    let queue = [];
    queue.push(0);
    let max = dp[0];
    for (let i = 1; i < n; i++) {

        dp[i] = Math.max(nums[i], dp[queue[0]] + nums[i]);
        max = Math.max(max, dp[i]);
        if (i - queue[0] >= k) {
            queue.shift();
        }

        while (queue.length && dp[queue[queue.length - 1]] <= dp[i]) {
            queue.pop();
        }

        queue.push(i);
    }

    return max;
};