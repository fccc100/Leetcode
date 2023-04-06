import java.util.Arrays;

class MinimumXORSum {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 1; mask < dp.length; mask++) {
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

// 输入：nums1 = [1,0,3], nums2 = [5,3,4]
// 输出：8
// ['001', '000', '011']
// ['101', '011', '100']
// 40
// 40

// [72,97,8,32,15]
// [63,97,57,60,83]
// ['1001000', '1100001', '0001000', '0100000', '0001111']
// 4 0   1 1
// ['0111111', '1100001', '0111001', '0111100', '1010011']
// 1 2
// 2 1
// 4 1
// 8