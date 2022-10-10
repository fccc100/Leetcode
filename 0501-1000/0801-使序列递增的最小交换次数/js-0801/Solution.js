/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minSwap = function (nums1, nums2) {
    let n = nums1.length;

    // dp[i][0] 表示到达位置i时并且i位置不进行交换的最小操作次数
    // dp[i][1] 表示到达位置i时并且i位置进行交换的最小操作次数
    let dp = Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = Array(2).fill(n + 1);
    }

    // nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]
    // nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]
    dp[0][0] = 0;
    dp[0][1] = 1;
    for (let i = 1; i < n; i++) {
        if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1] + 1;
        }
        if (nums2[i] > nums1[i - 1] && nums1[i] > nums2[i - 1]) {
            dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
        }
    }

    return Math.min(dp[n - 1][0], dp[n - 1][1]);
};