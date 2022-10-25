class MaximumsSplicedArray {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] diff1 = new int[n];
        int[] diff2 = new int[n];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            diff1[i] = nums2[i] - nums1[i];
            diff2[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        int diffSum1 = maxSubarraySum(diff1);
        int diffSum2 = maxSubarraySum(diff2);
        return Math.max(sum1 + diffSum1, sum2 + diffSum2);
    }

    private int maxSubarraySum(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        int max = prev;
        for (int i = 1; i < n; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }
}

// 输入：nums1 = [20,40,20,70,30], nums2 = [50,20,50,40,20]
// 输出：220
// 解释：选择 left = 3 和 right = 4 ，得到 nums1 = [20,40,20,40,20] 和 nums2 = [50,20,50,70,30] 。
// 分数为 max(sum(nums1), sum(nums2)) = max(140, 220) = 220 。

// 设 nums1 中选出和为a, nums2中选出和为b
// 替换之后nums1的和： sum(nums1) + (b - a);
// 替换之后nums2的和： sum(nums2) + (a - b);

// 转化为求max( sum(nums1) + (b - a), sum(nums2) + (a - b) )