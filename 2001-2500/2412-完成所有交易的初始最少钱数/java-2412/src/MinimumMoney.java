class MinimumMoney {
    public long minimumMoney(int[][] transactions) {
        int n = transactions.length;

        long totalLose = 0;
        for (int i = 0; i < n; i++) {
            if (transactions[i][0] > transactions[i][1]) {
                totalLose += transactions[i][0] - transactions[i][1];
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (transactions[i][0] >transactions[i][1]) {
                res = Math.max(res, (totalLose - (transactions[i][0] - transactions[i][1])) + transactions[i][0]);
            } else {
                res = Math.max(res, totalLose + transactions[i][0]);
            }
        }
        return res;
    }
}