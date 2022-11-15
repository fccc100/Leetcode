import java.util.Arrays;

class NumberOfPairs {
    int diff;
    long res;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        this.diff = diff;

        int[] diffNums = new int[n];
        for (int i = 0; i < n; i++) {
            diffNums[i] = nums1[i] - nums2[i];
        }

        getPairs(diffNums);
        return res;
    }

    private void getPairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l >> 1);

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        for(int i = l, j = mid + 1; j <= r; j++){
            while(i <= mid && (nums[i] <= nums[j] + diff)){
                i++;
            }
            res += (i - l);
        }

        merge(nums, l, mid, r);
    }

    private long merge(int[] nums, int l, int mid, int r) {
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
                nums[k] = temp[j - l];
                j++;
            }
        }
        return res;
    }
}
