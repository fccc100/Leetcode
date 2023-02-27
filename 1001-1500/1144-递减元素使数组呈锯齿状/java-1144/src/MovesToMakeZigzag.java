import java.util.Arrays;

class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0, n);
        int res1 = 0;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n && temp[i + 1] >= temp[i]) {
                res1 += temp[i + 1] - temp[i] + 1;
                temp[i + 1] = temp[i] - 1;
            }
            if (i - 1 >= 0 && temp[i - 1] >= temp[i]) {
                res1 += temp[i - 1] - temp[i] + 1;
                temp[i - 1] = temp[i] - 1;
            }
        }
        int res2 = 0;
        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n && nums[i + 1] >= nums[i]) {
                res2 += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
            if (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
                res2 += nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
        }
        return Math.min(res1, res2);
    }
}