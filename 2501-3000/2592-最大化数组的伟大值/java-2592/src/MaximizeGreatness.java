import java.util.Arrays;

class MaximizeGreatness {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0, i = n - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums[i] > nums[j]) {
                res ++;
                i --;
                j --;
            } else {
                j --;
            }
        }
        return res;
    }
}