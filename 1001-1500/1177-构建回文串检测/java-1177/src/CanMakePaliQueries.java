import java.util.ArrayList;
import java.util.List;

class CanMakePaliQueries {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();

        // cnt[i][j]: s前i个字符中j出现的次数
        int[][] cnt = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                cnt[i][j] = cnt[i - 1][j];
            }
            cnt[i][s.charAt(i - 1) - 'a']++;
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][2];
            int oddCnt = 0;
            for (int j = 0; j < 26; j++) {
                int charCnt = cnt[queries[i][1] + 1][j] - cnt[queries[i][0]][j];

                if (charCnt % 2 == 1) {
                    oddCnt++;
                }
            }
            res.add(oddCnt / 2 <= k);
        }
        return res;
    }
}
