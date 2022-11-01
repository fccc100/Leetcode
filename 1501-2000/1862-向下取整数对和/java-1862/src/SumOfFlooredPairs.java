class SumOfFlooredPairs {
    public int sumOfFlooredPairs(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }

        int[] presum = new int[max + 1];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + cnt[i];
        }

        long res = 0;
        for (int i = 1; i <= max; i++) {
            if (cnt[i] > 0) {
                for (int j = 1; j * i <= max; j++) {
                    long t = (presum[Math.min((j + 1) * i - 1, max)] - presum[j * i - 1]) ;
                    res = (res + (long) cnt[i] * j * t) % mod;
                }
            }
        }
        return (int) res % mod;
    }
}

// [2, 5, 9]

//  0  1  2  3  4  5  6  7  8  9
// [0, 0, 1, 0, 0, 1, 0, 0, 0, 1]

// 1 2 3 4

// [2, 3]
//        0
//        0
//        1
//        0
//        0
//        1
//        0
//        0
//        0
//        1
//        -----
//        0
//        0
//        0
//        1
//        1
//        1
//        2
//        2
//        2
//        2
//        3
