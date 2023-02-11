class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (costs[i] > coins) return res;
            coins -= costs[i];
            res++;
        }
        return res;
    }
}