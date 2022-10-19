import java.util.Arrays;

class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        int res = 1;
        while (r + 1 < n) {
            r++;
            int len = r - l;

            int diff = nums[r] - nums[r - 1];
            int sumDiff = diff * len;
            k -= sumDiff;

            if (k < 0) {
                k += nums[r] - nums[l];
                l++;
            } else {
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}