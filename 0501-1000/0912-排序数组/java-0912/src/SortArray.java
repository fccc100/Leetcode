import java.util.Arrays;

// 归并排序
class SortArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergeSort(nums, 0, n - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);

        int i = l;
        int j = mid + 1;
        int idx = l;
        while (i <= mid || j <= r) {
            int cur = nums[l];
            if (i > mid) {
                cur = temp[j - l];
                j++;
            } else if (j > r) {
                cur = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                cur = temp[i - l];
                i++;
            } else {
                cur = temp[j - l];
                j++;
            }
            nums[idx] = cur;
            idx++;
        }
    }
}