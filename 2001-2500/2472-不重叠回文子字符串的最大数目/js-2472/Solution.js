/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxPalindromes = function (s, k) {
    let n = s.length

    let dp = longestPalindrome(s)

    let minR = Array(n).fill(-1)
    for (let i = 0; i < dp.length; i++) {

        for (let j = i; j < dp.length; j++) {
            if (dp[i][j]) {
                if (j - i + 1 >= k) {
                    minR[i] = j
                    break
                }
            }
        }
    }
    let res = 0
    for (let i = 0; i < n; i++) {
        let cur = 0
        let nextStart = n
        for (let j = n - 1; j >= i; j--) {
            if (minR[j] >= 0 && minR[j] < nextStart) {
                cur++
                nextStart = j
            }
        }

        res = Math.max(res, cur)
    }
    return res
};

function longestPalindrome(s) {
    // 状态定义：dp[i][j]表示字符串s在[i, j]范围是否是回文串
    let dp = Array(s.length);

    // 状态初始化：i，j相等时，单个字符肯定是回文
    for (let i = 0; i < s.length; i++) {
        dp[i] = Array(s.length);
        dp[i][i] = true;
    }

    for (let j = 1; j < s.length; j++) {
        for (let i = 0; i < j; i++) {
            if (s[i] !== s[j]) {
                dp[i][j] = false;
            } else {
                if (j - i <= 2) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
    }

    return dp;
}