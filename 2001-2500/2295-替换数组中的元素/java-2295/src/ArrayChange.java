import java.util.HashMap;

class ArrayChange {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            int key = operations[i][0];
            int val = operations[i][1];
            nums[map.get(key)] = val;
            map.put(val, map.get(key));
            map.remove(key);
        }
        return nums;
    }
}