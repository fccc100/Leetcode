import java.util.HashMap;

class CountNicePairs {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int MOD = 1000000007;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int revX = Integer.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());

            if (map.containsKey(x - revX)) {
                res = (res + map.get(x - revX)) % MOD;
            }

            map.put(x - revX, map.getOrDefault(x - revX, 0) + 1);
        }
        return res % MOD;
    }
}