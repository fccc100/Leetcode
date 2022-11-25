class Search2 {
    // 二分查找
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[0]) {
                // 右侧有序
                if (target > nums[mid] && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
