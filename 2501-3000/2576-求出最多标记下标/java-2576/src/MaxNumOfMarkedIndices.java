import java.util.Arrays;

class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = n >> 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(nums, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l * 2;
    }
    private boolean check(int[] nums, int k) {
        int l = 0;
        int r = nums.length - k;
        while (k > 0) {
            if (nums[l] * 2 > nums[r]) return false;
            l++;
            r++;
            k--;
        }
        return true;
    }
}