import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ReductionOperations {
    public int reductionOperations(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                cnt++;
            }
            res += cnt;
        }
        return res;
    }
}