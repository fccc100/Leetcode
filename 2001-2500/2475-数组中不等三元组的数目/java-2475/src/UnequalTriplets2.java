public class UnequalTriplets2 {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;

        int res = 0;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] cnt = new int[max + 1];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }

        int pre = 0;
        for (int i = 0; i < cnt.length; i++) {
            int next = n - cnt[i] - pre;
            res += pre * next * cnt[i];
            pre += cnt[i];
        }
        return res;
    }
}