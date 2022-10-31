class MakeIntegerBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
        if (sum(n) <= target) {
            return 0;
        } else {
            long t = 10;
            long temp = n;
            while (sum(temp) > target) {
                long m = t - (n % t);
                temp = (n / t + 1) * 10;

                if (sum(temp) <= target) {
                    return m;
                } else {
                    temp = n;
                    t *= 10;
                }
            }
        }
        return 0;
    }

    private int sum(long n) {
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        return res;
    }
}