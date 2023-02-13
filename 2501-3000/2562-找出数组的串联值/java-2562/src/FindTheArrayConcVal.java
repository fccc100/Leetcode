class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        long res = 0;
        while (l <= r) {
            if (l == r) {
                res += nums[l];
            } else {
                res += Integer.valueOf(String.valueOf(nums[l]) + String.valueOf(nums[r]));
            }
            l++;
            r--;
        }
        return res;
    }
}