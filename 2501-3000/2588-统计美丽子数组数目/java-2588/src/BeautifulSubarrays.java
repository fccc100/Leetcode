class BeautifulSubarrays {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            pre = pre ^ nums[i];
            if (pre == 0) res ++;
            if (map.containsKey(pre)) {
                res += map.get(pre);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}