import java.util.Arrays;

class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int first = -1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && first < 0) {
                first = i + 1;
            }
            curSum += nums[i];
        }

        if (first < 0) {
            return new int[] {nums[n - 1] + 1, nums[n - 1] + 2};
        }

        int sum = (n + 2) * (1 + n + 2) / 2;
        return new int[] {first, sum - curSum - first};
    }
}