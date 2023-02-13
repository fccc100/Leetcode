import java.util.Arrays;

class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] * 2 > upper) break;
            int min = lower - nums[i] - 1;
            int max = upper - nums[i] + 1;
            // 大于min的最小值
            int lower_idx = lower(nums, min);
            // 小于max的最大值
            int upper_idx = upper(nums, max);

            res += upper_idx - Math.max(lower_idx, i + 1) + 1;
        }
        return res;
    }
    private int lower(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    private int upper(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}

// [0,1,7,4,4,5]
// [0,1,4,4,5,7]