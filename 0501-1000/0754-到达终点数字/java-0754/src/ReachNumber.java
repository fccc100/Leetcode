class ReachNumber {
    public int reachNumber(int target) {
        if (target == 0) return 0;

        target = Math.abs(target);

        int p = 1;
        while (preSum(p) < target) {
            p++;
        }

        int sum = preSum(p);
        if (sum == target) return p;

        if ((sum - target) % 2 == 0) return p;

        if ((preSum(p + 1) - target) % 2 == 0) return p + 1;
        if ((preSum(p + 2) - target) % 2 == 0) return p + 2;

        return 0;
    }

    private int preSum(int n) {
        return n * (n + 1) / 2;
    }
}


// 0 1 2 3 4 5 6 7 8 9 10 11 12 13