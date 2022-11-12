import java.util.Arrays;
import java.util.TreeSet;

class SubarraysWithMoreZerosThanOnes {
    int mod = 1000000007;
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;

        // 把0当作-1， 先求前缀和，再求每个位置左边比其小的元素个数
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        reverse(presum);

        return reversePairs(presum);
    }

    private void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;

        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int res = 0;

        int mid = l + (r - l >> 1);
        res = (res + mergeSort(nums, l, mid)) % mod;
        res = (res + mergeSort(nums, mid + 1, r)) % mod;
        if (nums[mid] > nums[mid + 1]) {
            res = (res + merge(nums, l, mid, r)) % mod;
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
                res = (res + mid - i + 1) % mod;
                nums[k] = temp[j - l];
                j++;
            }
        }
        return res;
    }
}

//          [0,  1,  1,  0,  1]
//          [-1, 1,  1, -1,  1]
// presum [0, -1, 0,  1,  0,  1]