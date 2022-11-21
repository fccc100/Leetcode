class UnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}