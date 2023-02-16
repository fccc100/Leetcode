class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 2] = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }

        int leftMax = nums[0];
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (leftMax < nums[i] && nums[i] < rightMin[i]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        return res;
    }
}