import java.util.Arrays;

class MinimumTimeRequired {

    // TLE
    int n;
    int k;
    int[] jobs;
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        n = jobs.length;
        this.k = k;
        this.jobs = jobs;

        int[] nums = new int[k];
        dfs(nums, n - 1);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index < 0) {
            int max = nums[0];
            for (int i = 0; i < k; i++) {
                max = Math.max(max, nums[i]);
            }
            res = Math.min(res, max);
            return;
        }

        int zeroCnt = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            }

            if (nums[i] > res) return;
        }

        if (zeroCnt > index + 1) return;

        for (int i = 0; i < k; i++) {
            if (index == n - 1 && i > 0) return;
            nums[i] += jobs[index];
            dfs(nums, index - 1);
            nums[i] -= jobs[index];
        }
    }
}