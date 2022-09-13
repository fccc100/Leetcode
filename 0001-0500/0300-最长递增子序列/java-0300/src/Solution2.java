public class Solution2 {
    // 贪心 + 二分
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // dp[i]表示长度为i的最长递增子序列的末尾元素最小值
        int[] dp = new int[n + 1];
        int len = 1;
        dp[len] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                // dp数组中[0, len]区间小于nums[i]的最大值索引
                int pos = lower(dp, 0, len, nums[i]);

                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }

    private int lower(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(new Solution1().lengthOfLIS(nums));
    }
}
