import java.util.Arrays;

class ReinitializePermutation {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            arr[i] = i;
        }
        int res = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = Arrays.copyOf(arr, n);
            res++;
            if (check(perm)) {
                return res;
            }
        }
    }
    private boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return false;
        }
        return true;
    }
}