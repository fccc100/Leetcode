import java.util.Arrays;

class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        String lcs = dp[m][n];
        int j = 0;
        int k = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lcs.length(); i++) {
            while (str1.charAt(j) != lcs.charAt(i)) {
                res.append(str1.charAt(j));
                j++;
            }
            while (str2.charAt(k) != lcs.charAt(i)) {
                res.append(str2.charAt(k));
                k++;
            }
            res.append(lcs.charAt(i));
            j++;
            k++;
        }
        res.append(str1.substring(j));
        res.append(str2.substring(k));
        return res.toString();
    }
}

// 输入：str1 = "ab ac", str2 = "c ab"
// 输出："cabac"