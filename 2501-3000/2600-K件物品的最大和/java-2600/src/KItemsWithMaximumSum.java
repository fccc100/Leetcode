class KItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        while (k > 0) {
            if (numOnes > 0) {
                res++;
                numOnes--;
            } else if (numZeros > 0) {
                numZeros--;
            } else {
                res--;
            }
            k--;
        }
        return res;
    }
}