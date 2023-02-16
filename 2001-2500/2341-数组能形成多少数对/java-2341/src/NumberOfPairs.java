import java.util.HashSet;

class NumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                res[0]++;
            } else {
                set.add(nums[i]);
            }
        }
        res[1] = n - 2 * res[0];
        return res;
    }
}