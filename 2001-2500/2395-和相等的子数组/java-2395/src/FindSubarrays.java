import java.util.HashSet;
import java.util.Set;

class FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int c = nums[i] + nums[i + 1];
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }
}