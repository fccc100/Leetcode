import java.util.Arrays;

class MiceAndCheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int res = 0;
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[]{reward1[i], reward2[i]};
        }

        Arrays.sort(p, (a, b) -> (b[0] - b[1]) - (a[0] - a[1]));

        for (int i = 0; i < k; i++) {
            res += p[i][0];
        }
        for (int i = k; i < n; i++) {
            res += p[i][1];
        }
        return res;
    }
}