public class maxSumTwoNoOverlap2 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(f(nums, firstLen, secondLen), f(nums, secondLen, firstLen));
    }
    private int f(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int sumL = 0;
        for (int i = 0; i < firstLen; i++) {
            sumL += nums[i];
        }
        int sumR = 0;
        for (int i = firstLen; i < firstLen + secondLen; i++) {
            sumR += nums[i];
        }

        int maxSumL = sumL;
        int res = sumL + sumR;
        int r = firstLen + secondLen;

        while (r < n) {
            sumR += nums[r];
            sumR -= nums[r - secondLen];

            sumL += nums[r - secondLen];
            sumL -= nums[r - secondLen - firstLen];
            maxSumL = Math.max(sumL, maxSumL);
            res = Math.max(res, maxSumL +sumR);
            r++;
        }

        return res;
    }
}
