class ProductQueries {
    public int[] productQueries(int n, int[][] queries) {
        int m = queries.length;
        int mod = 1000000007;

        int[] res = new int[m];
        int[] pows = new int[32];
        pows[0] = 1;
        for (int i = 1; i < 32; i++) {
            pows[i] = pows[i - 1] * 2;
        }
        for (int i = 0; i < m; i++) {
            int oneCnt = 0;
            long cur = 1;
            for (int j = 0; j < 30; j++) {
                if ((n & (1 << j)) != 0) {
                    oneCnt++;
                    if (oneCnt >= queries[i][0] + 1 && oneCnt <= queries[i][1] + 1) {
                        cur = (pows[j] * cur) % mod;
                    }
                }
                if (oneCnt >= queries[i][1] + 1) break;
            }
            res[i] = (int)cur;
        }
        return res;
    }
}