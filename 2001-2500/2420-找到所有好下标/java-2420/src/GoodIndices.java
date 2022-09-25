import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;

        int[] leftDp = new int[n];
        Arrays.fill(leftDp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                leftDp[i] = leftDp[i - 1] + 1;
            }
        }

        int[] rightDp = new int[n];
        Arrays.fill(rightDp, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                rightDp[i] = rightDp[i + 1] + 1;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i - 1 >= 0 ? leftDp[i - 1] : 0) >= k && (i + 1 < n ? rightDp[i + 1] : 0) >= k) {
                res.add(i);
            }
        }
        return res;
    }
}