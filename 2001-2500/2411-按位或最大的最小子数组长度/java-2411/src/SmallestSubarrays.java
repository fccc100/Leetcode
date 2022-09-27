import java.util.Arrays;

class SmallestSubarrays {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;

        int[] dp = new int[32];
        Arrays.fill(dp, -1);

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int max = 1;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    // 这一位上是1，不需要通过 或 其他值来使得这一位变大了，记录本次1的位置
                    dp[j] = i;
                } else {
                    // 这一位上是0，看看通过 或 后面的某个数使其变成1最快是在哪一位
                    if (dp[j] > -1) {
                        max = Math.max(max, dp[j] - i + 1);
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }
}