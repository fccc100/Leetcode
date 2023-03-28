/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var shortestCommonSupersequence = function(str1, str2) {
    let m = str1.length;
    let n = str2.length;

    // 求lcs
    let dp = Array(m + 1);
    for (let i = 0; i <= m; i++) {
        dp[i] = Array(n + 1).fill('');
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + str1[i - 1];
            } else {
                dp[i][j] = dp[i - 1][j].length > dp[i][j - 1].length ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
    }

    let lcs = dp[m][n];
    let res = '';
    let j = 0;
    let k = 0;
    for (let i = 0; i < lcs.length; i++) {
        while(j < m && str1[j] != lcs[i]) {
            res += str1[j];
            j++;
        }
        while(k < n && str2[k] != lcs[i]) {
            res += str2[k];
            k++;
        }
        res += lcs[i];
        j++;
        k++;
    }
    res += str1.substr(j);
    res += str2.substr(k);
    return res;
};