class DistributeCookies {

    int n;
    int k;
    int[] cookies;
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        this.k = k;
        this.cookies = cookies;

        int[] nums = new int[k];
        dfs(nums, n - 1);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index < 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            res = Math.min(res, max);
            return;
        }

        // 剪枝1：未分到饼干的小朋友数量 > 剩余饼干数量了，无法再分直接返回
        int zeroCnt = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] == 0) zeroCnt++;

            // 剪枝2： 如果某位小朋友分到的饼干已经比当前得到的结果还大了，此次分发没有更优答案，直接返回
            if (nums[i] > res) return;
        }
        if (zeroCnt > index + 1) return;

        for (int i = 0; i < k; i++) {
            // 剪枝3：第一块饼干不管分给哪个小朋友，递归树都是一样的，只需要分一次就可以
            if (index == n - 1 && i > 0) return;

            nums[i] += cookies[index];
            dfs(nums, index - 1);
            nums[i] -= cookies[index];
        }
    }
}