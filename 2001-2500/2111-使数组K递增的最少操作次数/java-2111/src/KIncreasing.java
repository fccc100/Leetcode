import java.util.ArrayList;

class KIncreasing {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;

        int res = 0;
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                cur.add(arr[j]);
            }

            int[] nums = new int[cur.size()];
            int idx = 0;
            for (Integer num : cur) {
                nums[idx] = num;
                idx++;
            }

            res += nums.length - lengthOfLIS(nums);
        }
        return res;
    }

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
            if (nums[i] >= dp[len]) {
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
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
