import java.util.Arrays;

class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;

        Arrays.sort(potions);
        int[] pairs = new int[m];
        for (int i = 0; i < m; i++) {
            int x = spells[i];

            pairs[i] = check(x, potions, success);
        }
        return pairs;
    }

    private int check(int x, int[] nums, long k) {
        int n = nums.length;

        int l = 0;
        int r = n;

        while (l < r) {
            int mid = l + (r - l >> 1);
            long cur = (long) nums[mid] * (long) x;
            if (cur < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return n - l;
    }
}
