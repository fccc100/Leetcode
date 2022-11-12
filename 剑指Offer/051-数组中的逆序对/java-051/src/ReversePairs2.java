import java.util.Arrays;

class ReversePairs2 {
    public int reversePairs(int[] nums) {
        int n = nums.length;

        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int res = 0;

        int mid = l + (r - l >> 1);
        res += mergeSort(nums, l, mid);
        res += mergeSort(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r);
        }
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int i = l;
        int j = mid + 1;
        int res = 0;
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
        return res;
    }
}