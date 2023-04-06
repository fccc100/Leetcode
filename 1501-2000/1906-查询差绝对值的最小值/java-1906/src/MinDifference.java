class MinDifference {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        // preCnt[i][j]: nums前i个元素中包含j的个数
        int[][] preCnt = new int[n + 1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                preCnt[i][j] = preCnt[i - 1][j];
            }
            preCnt[i][nums[i - 1]]++;
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int prev = -1;
            int cur = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (preCnt[r + 1][j] - preCnt[l][j] > 0) {
                    if (prev == -1) {
                        prev = j;
                    } else {
                        cur = Math.min(cur, Math.abs(j - prev));
                        prev = j;
                    }
                }
            }
            res[i] = cur == Integer.MAX_VALUE ? -1 : cur;
        }
        return res;
    }
}

// 输入：nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
// 输出：[2,1,4,1]

