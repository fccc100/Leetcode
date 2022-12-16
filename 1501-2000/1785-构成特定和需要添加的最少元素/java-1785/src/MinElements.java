class MinElements {
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        long diff = Math.abs(sum - goal);
        return diff % limit == 0 ? (int)(diff / limit) : (int) (diff / limit) + 1;
    }
}