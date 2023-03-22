import java.util.Arrays;

class NumberOf2sInRange {
    String s;
    int[][] memo;
    public int numberOf2sInRange(int n) {
        s = String.valueOf(n);
        memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true);
    }
    private int f(int i, int cnt, boolean isLimit) {
        if (i == s.length()) return cnt;
        if (!isLimit && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int res = 0;
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (int d = 0; d <= up; d++) {
            res += f(i + 1, cnt + (d == 2 ? 1 :  0), isLimit && d == up);
        }
        if (!isLimit) memo[i][cnt] = res;
        return res;
    }
}

// 113
// 2 12 20 21 22 23 24 25 26 27 28 29 32 42 52 62 72 82 92 102 112