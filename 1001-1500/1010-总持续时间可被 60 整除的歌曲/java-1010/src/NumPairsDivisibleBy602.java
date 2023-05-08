public class NumPairsDivisibleBy602 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int res = 0;
        int[] cnts = new int[61];
        for (int i = 0; i < n; i++) {
            int m = time[i] % 60;
            if (m == 0) {
                res += cnts[0];
                cnts[0]++;
            } else {
                res += cnts[60 - m];
                cnts[m]++;
            }
        }
        return res;
    }
}
