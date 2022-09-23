class Search {
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }
}