public class CountSpecialNumbers {

    String s;
    int[][] memo;
    public int countSpecialNumbers(int n) {
        s = String.valueOf(n);
        memo = new int[s.length()][2000];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true, false);
    }
    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res = f(i + 1, mask, false, false);
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        int start = isNum ? 0 : 1;
        for (int d = start; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }
}
