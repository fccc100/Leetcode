class Search2 {
    public int search(int[] nums, int target) {
        int lowerIdx = lower(nums, target);
        int upperIdx = upper(nums, target);

        return upperIdx - lowerIdx - 1;
    }

    // 查询小于target的最大值的索引
    private int lower(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // 查询大于target的最小值的索引
    private int upper(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l >> 1);

            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}