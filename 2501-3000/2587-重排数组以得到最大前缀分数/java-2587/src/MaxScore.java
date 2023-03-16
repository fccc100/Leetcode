import java.util.Arrays;

class MaxScore {
    public int maxScore(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long presum =  nums[n - 1];
        int res = 0;
        if (presum > 0) res ++;

        for (int i = n - 2; i >= 0; i--) {
            presum += nums[i];
            if (presum > 0) res ++;
        }
        return res;
    }
}