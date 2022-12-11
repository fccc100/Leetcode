public class TriangularSum2 {
    // 原地
    public int triangularSum(int[] nums) {
        for (int n = nums.length - 1; n > 0; n--) {
            for (int i = 0; i < n; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
