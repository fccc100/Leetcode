import java.util.Arrays;

class Solution1 {
    // 最长公共子序列
    // 动态规划 O(n^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i]表示以i结尾的最长递增子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(new Solution1().lengthOfLIS(nums));
    }
}

