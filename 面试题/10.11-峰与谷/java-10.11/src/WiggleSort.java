import java.util.Arrays;

class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int l = 0;
        int r = n / 2;
        int[] temp = new int[n];
        int idx = 0;
        while (idx < n) {
            if (idx % 2 == 0) {
                temp[idx] = nums[r];
                r++;
            } else {
                temp[idx] = nums[l];
                l++;
            }
            idx++;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
