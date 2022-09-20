public class HammingDistance2 {
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }

    private int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
