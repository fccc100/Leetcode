class SumOfFlooredPairs {
    public int sumOfFlooredPairs(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }

        int[] presum = new int[max + 2];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + cnt[i - 1];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int y = nums[i];


        }
        return 0;
    }
}

// [2, 5, 9]

//  0  1  2  3  4  5  6  7  8  9
// [0, 0, 1, 0, 0, 1, 0, 0, 0, 1]

// 1 2 3 4

// [2, 3]