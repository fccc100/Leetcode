import java.util.Arrays;

class GetAverages {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        long[] presum = new long[n + 1];
        presum[0] = 0;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k || i >= n - k) {
                res[i] = -1;
            } else {
                long sum = presum[i + k + 1] - presum[i - k];
                res[i] = (int)(sum / (2 * k + 1));
            }
        }
        return res;
    }
}
