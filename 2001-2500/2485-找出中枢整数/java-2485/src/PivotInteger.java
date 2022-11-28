class PivotInteger {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        int presum = 0;
        for (int x = 1; x <= n; x++) {
            presum += x;
            if (presum == sum - presum + x) {
                return x;
            }
        }
        return -1;
    }
}