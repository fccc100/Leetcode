class CountQuadruplets {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        // grate[i][j]: i位置后面比nums[j]大的元素个数
        int[][] grate = new int[n][n + 1];
        for (int i = n - 2; i >= 2; i--) {
            grate[i] = grate[i + 1].clone();
            for (int x = nums[i + 1] - 1; x >= 0; x--) {
                grate[i][x]++;
            }
        }

        // less[i][j]：i位置前面比nums[j]小的元素个数
        int[][] less = new int[n][n + 1];
        for (int i = 1; i < n; i++) {
            less[i] = less[i - 1].clone();
            for (int x = n; x > nums[i - 1]; x--) {
                less[i][x]++;
            }
        }

        long res = 0;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] > nums[j]) {
                    res += less[i][nums[j]] * grate[j][nums[i]];
                }
            }
        }
        return res;
    }
}