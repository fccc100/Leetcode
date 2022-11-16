import java.util.Arrays;

public class LongestObstacleCourseAtEachPosition2 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int[] res = new int[n];

        // dp[i]表示长度为i的序列的最后一个元素的最小值
        int[] dp = new int[n + 1];
        int len = 1;
        dp[len] = obstacles[0];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            if (obstacles[i] >= dp[len]) {
                len++;
                dp[len] = obstacles[i];
                res[i] = len;
            } else {
                // 找到打于obstacles[i]的最小值的索引
                int insertPos = lower(dp, 0, len, obstacles[i]);

                dp[insertPos] = obstacles[i];
                res[i] = insertPos;
            }
        }

        return res;
    }

    private int lower(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
