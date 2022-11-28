class BestClosingTime {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] lastOne = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            lastOne[i] = lastOne[i + 1];
            if (customers.charAt(i) == 'Y') {
                lastOne[i] += 1;
            }
        }

        int[] preZero = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preZero[i] = preZero[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                preZero[i] += 1;
            }
        }

        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i <= n; i++) {
            if (preZero[i] + lastOne[i] < min) {
                min = preZero[i] + lastOne[i];
                res = i;
            }
        }
        return res;
    }
}