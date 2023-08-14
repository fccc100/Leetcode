class Solution {
    public static boolean checkArray(int[] nums, int k) {
        int n = nums.length;

        int[] diff = new int[n + 1];
        int presum = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            presum += diff[i];
            v += presum;
            if (v < 0) return false;
            if (v == 0) continue;
            if (i + k > n) return false;
            presum -= v;
            diff[i + k] += v;
        }

        return true;
    }
}

