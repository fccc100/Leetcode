class IsIdealPermutation {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;

        int min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }
        return true;
    }
}
