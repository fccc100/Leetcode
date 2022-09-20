public class MissingTwo2 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;

        // 先求所有数的异或
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            c ^= nums[i];
        }

        // 再跟 1 - n 的每个数字异或
        for (int i = 1; i <= n; i++) {
            c ^= i;
        }

        // 此时的 c 就是消失的两个数a和b的异或值: c = a ^ b
        // 因为c是a和b异或的结果，所以找到一个为1的二进制位就说明这个位上a b不一样
        int p = 1;
        while ((p & c) == 0) {
            p <<= 1;
        }
        // 上面找到的p就是a 和 b二进制位不相同的其中一位

        // 根据上面找到的这个位数将所有数分成两组分别异或
        // 相同的元素相同二进制位肯定相同，分在同一组
        // a和b在p位不相同，肯定分在不同组
        // 所以两组分别异或之和得到的结果就是消失的两个数
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & p) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & p) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }

        return new int[]{a, b};
    }
}
