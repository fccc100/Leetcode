class EvenProduct {
    public long evenProduct(int[] nums) {
        int n = nums.length;

        long res = 0;
        int lastEven = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                res += i + 1;
                lastEven = i;
            } else {
                if (lastEven >= 0) {
                    res += lastEven + 1;
                }
            }
        }
        return res;
    }
}
