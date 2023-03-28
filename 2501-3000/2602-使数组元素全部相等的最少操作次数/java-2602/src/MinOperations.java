import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinOperations {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int m = nums.length;
        int n = queries.length;

        Arrays.sort(nums);
        long[] presum = new long[m + 1];

        for (int i = 1; i <= m; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        List<Long> res = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {

            // 查询小于等于queries[i]的最大值
            int idx = upper_floor(nums, queries[i]);

            long lowsum = presum[idx + 1];
            long gratesum = presum[m] - presum[idx + 1];

            res.add((((long) queries[i] * (idx + 1)) - lowsum) + (gratesum - ((long) queries[i] * (m - idx - 1))));
        }
        return res;
    }
    private int upper_floor(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;
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