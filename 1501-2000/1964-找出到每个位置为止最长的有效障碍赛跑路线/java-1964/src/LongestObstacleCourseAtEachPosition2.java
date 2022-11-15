import java.util.Arrays;

public class LongestObstacleCourseAtEachPosition2 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
//        int n = obstacles.length;
//        if (n == 0) {
//            return new int[]{};
//        }
//
//        // dp[i]表示长度为i的最长递增子序列的末尾元素最小值
//        int[] dp = new int[n + 1];
//        int[] res = new int[n];
//        Arrays.fill(res, 1);
//        int len = 1;
//        dp[len] = obstacles[0];
//
//        for (int i = 1; i < n; i++) {
//            if (obstacles[i] > dp[len]) {
//                len++;
//                dp[len] = obstacles[i];
//                res[i] = Math.max(res[i], len);
//            } else {
//
//                // dp数组中[0, len]区间小于nums[i]的最大值索引
//                int pos = lower(dp, 0, len, obstacles[i]);
//
//                dp[pos + 1] = obstacles[i];
//                res[i] = Math.max(res[i], pos + 1);
//            }
//        }
//        return res;
        return new int[]{};
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
}
