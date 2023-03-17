import java.util.Arrays;

class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length;
        Arrays.sort(nums);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int t = queries[i];
            int cur = 0;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (sum + nums[j] <= t) {
                    sum += nums[j];
                    cur++;
                } else {
                    break;
                }
            }
            res[i] = cur;
        }
        return res;
    }
}