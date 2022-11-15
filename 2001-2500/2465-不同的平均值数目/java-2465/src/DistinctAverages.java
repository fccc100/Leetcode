import java.util.Arrays;
import java.util.HashSet;

class DistinctAverages {
    public int distinctAverages(int[] nums) {
        int n = nums.length;

        HashSet<Double> set = new HashSet<>();
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            set.add((nums[l] + nums[r]) / 2.0);
            l++;
            r--;
        }
        return set.size();
    }
}