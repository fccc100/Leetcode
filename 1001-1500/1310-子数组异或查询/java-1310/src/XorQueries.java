class XorQueries {
    // 前缀异或
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        if (n == 0) return new int[0];

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
        }
        return res;
    }
}