public class NumberOfSubarrays2 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int oddCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                oddCnt++;
            }
        }

        int[] odds = new int[oddCnt + 2];
        odds[0] = -1;
        odds[oddCnt + 1] = n;
        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                odds[idx] = i;
                idx++;
            }
        }

        int res = 0;
        for (int i = 1; i + k < odds.length; i++) {
            int r = i + k - 1;
            res += (odds[i] - odds[i - 1]) * (odds[r + 1] - odds[r]);
        }
        return res;
    }
}
