import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class SumSubseqWidths {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;

        Arrays.sort(nums);

        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % mod;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) (pow2[i] - pow2[n - 1 - i]) * nums[i];
        }

        return (int) (res % mod + mod) % mod;
    }
}
