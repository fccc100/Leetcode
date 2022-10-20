class KthGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k == 1) return 0;

        int prevK = kthGrammar(n - 1, (k + 1) >> 1);
        if (prevK == 0) {
            if (k % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (k % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
