public class MaxAscendingSum2 {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i];
            } else {
                curSum = nums[i];
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}