import java.util.Arrays;

class ReversePairs {
    int res;
    public int reversePairs(int[] nums) {
        int n = nums.length;

        res = 0;
        mergeSort(nums, 0, n - 1);
        return res;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j - l];
                j++;
            } else if (j > r) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] <= temp[j - l]) {
                nums[k] = temp[i - l];
                i++;
            } else {
                res += mid - i + 1;
                nums[k] = temp[j - l];
                j++;
            }
        }
    }
}