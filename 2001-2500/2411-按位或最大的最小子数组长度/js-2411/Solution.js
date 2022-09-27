/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallestSubarrays = function (nums) {
    let n = nums.length;

    // dp[i]表示第i位上的1最近出现的位置
    let dp = Array(32).fill(-1);
    let res = Array(n);
    for (let i = n - 1; i >= 0; i--) {

        let max = 1;
        for (let j = 0; j < 32; j++) {
            if ((nums[i] & (1 << j)) != 0) {
                dp[j] = i;
            } else {
                if (dp[j] > -1) {
                    max = Math.max(max, dp[j] - i + 1);
                }
            }
        }
        res[i] = max;
    }
    return res;
};