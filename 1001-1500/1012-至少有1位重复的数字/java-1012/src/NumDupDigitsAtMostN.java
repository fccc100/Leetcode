import java.util.Arrays;

class NumDupDigitsAtMostN {
    String s;
    int[][] memo;
    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n);
        memo = new int[s.length()][2000];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return n - f(0, 0, true, false);
    }

    private int f(int index, int mask, boolean isLimit, boolean isNum) {
        if (index == s.length()) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[index][mask] != -1) {
            return memo[index][mask];
        }
        int res = 0;
        if (!isNum) {
            res += f(index + 1, mask, false, false);
        }
        int up = isLimit ? s.charAt(index) - '0' : 9;
        int start = isNum ? 0 : 1;
        for (int d = start; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += f(index + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[index][mask] = res;
        }
        return res;
    }
}