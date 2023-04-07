import java.util.Arrays;

public class MinimumXORSum2 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // dp[i]表示nums2选择状态为i时选择nums1前bitCount(i)个时的最小值
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 1; mask < 1 << n; mask++) {
            int c = bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.min(dp[mask], dp[mask ^ (1 << i)] + (nums1[c - 1] ^ nums2[i]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
    private int bitCount(int n) {
        int res = 0;
        while (n > 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
