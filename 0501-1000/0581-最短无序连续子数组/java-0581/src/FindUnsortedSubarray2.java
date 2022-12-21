public class FindUnsortedSubarray2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = -1;
        int r = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                l = i;
            }
        }
        return l > -1 && r > - 1 ? r - l + 1 : 0;
    }
}
