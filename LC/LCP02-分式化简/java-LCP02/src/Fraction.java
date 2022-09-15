public class Fraction {

    public int[] fraction(int[] cont) {
        int n = cont.length;
        if (n == 0) return new int[]{0, 0};
        if (n == 1) return new int[]{cont[0], 1};

        int[] res = {1, cont[n - 1]};

        for (int i = n - 2; i >= 0; i--) {
            res[0] = res[0] + res[1] * cont[i];

            if (i > 0) {
                int temp = res[0];
                res[0] = res[1];
                res[1] = temp;
            }
        }
        return res;
    }
}
