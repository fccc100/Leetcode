import java.util.Arrays;

class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int res = 0;
        int presum = 0;
        int all = 0;
        for (int i = n - 1; i >= 0; i--) {
            all += satisfaction[i] + presum;
            presum += satisfaction[i];
            res = Math.max(res, all);
        }
        return res;
    }
}