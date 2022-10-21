public class MinKBitFlips2 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;

        int[] diff = new int[n + 1];

        int flipCnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            flipCnt += diff[i];
            // 0翻转偶数次和1翻转奇数次的位置都需要再次翻转
            if (nums[i] == 0) {
                if (flipCnt % 2 == 0) {
                    if (i + k > n) return -1;

                    diff[i]++;
                    flipCnt++;
                    diff[i + k]--;
                    res++;
                }
            } else {
                if (flipCnt % 2 == 1) {
                    if (i + k > n) return -1;
                    diff[i]++;
                    flipCnt++;
                    diff[i + k]--;
                    res++;
                }
            }
        }

        return res;
    }
}
