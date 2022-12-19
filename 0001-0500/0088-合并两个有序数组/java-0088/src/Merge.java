import java.util.Arrays;

class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOfRange(nums1, 0, nums1.length);
        int i = 0;
        int j = 0;
        for (int k = 0; k < nums1.length; k++) {
            if (i >= m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j >= n) {
                nums1[k] = temp[i];
                i++;
            } else if (temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}