
class Decrypt {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int t = k;

                for (int j = (i + 1 >= n ? 0: i + 1); t > 0; t--) {
                    sum += code[j];
                    j = (j + 1) % n;
                }
                res[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int t = k;

                for (int j = (i - 1 < 0 ? n - 1 : i - 1); t < 0; t++) {
                    sum += code[j];
                    j = (j + n - 1) % n;
                }
                res[i] = sum;
            }
        }
        return res;
    }
}
