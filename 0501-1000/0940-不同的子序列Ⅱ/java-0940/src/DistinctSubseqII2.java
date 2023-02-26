public class DistinctSubseqII2 {
    public int distinctSubseqII(String s) {
        int n = s.length();
        // preCnt[i]表示之前以i结尾的不同子序列个数
        int[] preCnt = new int[26];

        int MOD = 1000000007;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int prev = preCnt[c];
            preCnt[c] = (res + 1) % MOD;
            res = ((res + preCnt[c] - prev) % MOD + MOD) % MOD;
        }
        return res;
    }
}
