class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int[] cnts = new int[501];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 500; j++) {
                if ((j + time[i]) % 60 == 0) {
                    res += cnts[j];
                }
            }
            cnts[time[i]]++;
        }
        return res;
    }
}