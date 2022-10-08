class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int res = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}