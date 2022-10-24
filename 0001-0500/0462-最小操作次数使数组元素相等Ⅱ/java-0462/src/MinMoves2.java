import java.util.Arrays;

class MinMoves2 {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int target =  nums[n >> 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - target);
        }
        return res;
    }
}