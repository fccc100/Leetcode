class PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int[] rightMin = new int[n];
        rightMin[n - 1] = Integer.MIN_VALUE;
        int curMin = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = curMin;
            curMin = Math.min(curMin, nums[i]);
        }

        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (curMax <= rightMin[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}