class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        int l = 0;
        int r;
        int max = 0;
        for (r = 0; r <= minutes - 1; r++) {
            if (grumpy[r] == 1) {
                max += customers[r];
            }
        }
        r--;

        int cur = max;
        while (r + 1 < n) {
            r++;
            if (grumpy[r] == 1) {
                cur += customers[r];
            }

            if (grumpy[l] == 1) {
                cur -= customers[l];
            }
            l++;
            max = Math.max(max, cur);
        }

        return sum + max;
    }
}