class MaxPerformance {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long MOD = 1000000007;
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[]{speed[i], efficiency[i]};
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Arrays.sort(p, (a, b) -> b[1] - a[1]);

        long sum = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + p[i][0];
            res = Math.max(res, sum * p[i][1]);
            pq.offer(p[i]);
            if (pq.size() == k) {
                sum = (sum - pq.poll()[0] + MOD) % MOD;
            }
        }
        return (int)(res % MOD);
    }
}