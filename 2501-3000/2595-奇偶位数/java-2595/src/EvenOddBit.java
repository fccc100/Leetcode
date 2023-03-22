class EvenOddBit {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int idx = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                res[idx]++;
            }
            idx = 1 - idx;
            n >>= 1;
        }
        return res;
    }
}