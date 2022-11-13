import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountSmaller {
    List<Integer> res;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }

        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        mergeSort(temp, 0, n - 1);
        return res;
    }

    private void mergeSort(int[][] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[][] nums, int l, int mid, int r) {
//        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int[][] temp = new int[r - l + 1][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = nums[i + l][0];
            temp[i][1] = nums[i + l][1];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k][0] = temp[j - l][0];
                nums[k][1] = temp[j - l][1];
                j++;
            } else if (j > r) {
                nums[k][0] = temp[i - l][0];
                nums[k][1] = temp[i - l][1];
                res.set(temp[i - l][1], res.get(temp[i - l][1]) + j - mid - 1);
                i++;
            } else if (temp[i - l][0] <= temp[j - l][0]) {
                res.set(temp[i - l][1], res.get(temp[i - l][1]) + j - mid - 1);
                nums[k][0] = temp[i - l][0];
                nums[k][1] = temp[i - l][1];
                i++;
            } else {
                nums[k][0] = temp[j - l][0];
                nums[k][1] = temp[j - l][1];
                j++;
            }
        }
    }
}