import java.util.Arrays;

class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int res = 1;
        int curMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - curMin > k) {
                res++;
                curMin = nums[i];
            }
        }
        return res;
    }
}