import java.util.Arrays;

class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        int l = -1;
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                l = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                r = i;
                break;
            }
        }
        return l > -1 && r > - 1 ? r - l + 1 : 0;
    }
}