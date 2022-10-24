public class PartitionDisjoint2 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int leftMax = nums[0];
        int curMax = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                res = i;
                leftMax = curMax;
            }
        }
        return res + 1;
    }
}
