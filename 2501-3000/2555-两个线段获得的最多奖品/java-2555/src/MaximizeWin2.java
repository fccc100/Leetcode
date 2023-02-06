public class MaximizeWin2 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int l = 0;
        int res = 0;
        int[] pre = new int[n + 1];
        for (int r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            res = Math.max(res, r - l + 1 + pre[l]);
            pre[r + 1] = Math.max(pre[r], r - l + 1);
        }
        return res;
    }
}
