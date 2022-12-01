
class CountPalindromes {
    public int countPalindromes(String s) {
        int n = s.length();
        long MOD = (long) 1e9 + 7;

        // sufCnt[i]记录当前后缀中有多少个i
        int[] sufCnt = new int[10];
        // suf[i][j]表示当前后缀 [i, j] 数对的个数
        int[][] suf = new int[10][10];
        for (int i = n - 1; i >= 0; i--) {
            int cur = s.charAt(i) - '0';

            for (int j = 0; j < 10; j++) {
                suf[cur][j] += sufCnt[j];
            }
            sufCnt[cur]++;
        }

        // preCnt[i]记录当前前缀中有多少个i
        int[] preCnt = new int[10];
        // pre[i][j]表示当前前缀 [i, j] 数对的个数
        int[][] pre = new int[10][10];
        long res = 0;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - '0';
            sufCnt[cur]--;

            for (int j = 0; j < 10; j++) {
                suf[cur][j] -= sufCnt[j];
            }

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int l = pre[j][k];
                    int r = suf[j][k];

                    res += (long) l * r;
                }
            }

            for (int j = 0; j < 10; j++) {
                pre[cur][j] += preCnt[j];
            }
            preCnt[cur]++;
        }
        return (int)(res % MOD);
    }
}
