import java.util.Arrays;
import java.util.HashSet;

class MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] presum = new int[n + 1];
        for (int i = 1; i < n; i++) {
            presum[i + 1] = presum[i];
            if (nums[i] == nums[i - 1]) {
                presum[i + 1] ++;
            }
        }

        int res = n + 1;
        for (int i = 0; i < n; i++) {
            // 小于等于nums[i] + n - 1的最大值
            int upper = upper(nums, nums[i] + n - 1);
            res = Math.min(res, n - (upper - i + 1) + presum[upper + 1] - presum[i]);
        }
        return res;
    }
    // 查找小于等于target的最大值
    private int upper(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}

// [41,33,29,33,35,26,47,24,18,28]
// [18,24,26,28,29,33,33,35,41,47]
// [18

// [8,5,9,9,8,4]
// [4,5,8,8,9,9]

//  0 0 0 1 1 2 0
