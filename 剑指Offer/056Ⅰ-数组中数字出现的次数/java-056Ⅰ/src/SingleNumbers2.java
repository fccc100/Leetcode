public class SingleNumbers2 {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;

        int c = nums[0];
        for (int i = 1; i < n; i++) {
            c ^= nums[i];
        }

        int p = 1;
        while ((p & c) == 0) {
            p <<= 1;
        }

        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & p) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[] {a, b};
    }
}
