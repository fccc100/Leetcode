class SubStrHash {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();

        long mod = modulo;
        long[] modP = new long[n + 1];
        modP[0] = 1;
        for (int i = 1; i <= n; i++) {
            modP[i] = (modP[i - 1] * power) % mod;
        }

        long hash = 0;
        for (int i = n - 1; i >= n - k; i--) {
            int code = s.charAt(i) - 'a' + 1;

            hash = (hash + (code * modP[i - (n - k)]) % mod) % mod;
        }

        int l = n - k, r = n - 1;
        String res = "";
        if (hash == hashValue) {
            res = s.substring(n - k);
        }
        while (l > 0) {
            int coder = s.charAt(r) - 'a' + 1;
            hash = (hash - ((coder * modP[k - 1]) % mod) + mod) % mod;
            r--;

            hash = (hash * power) % mod;

            l++;
            int codel = s.charAt(l) - 'a' + 1;
            hash = (hash + (codel * modP[0]) % mod) % mod;

            if (hash == hashValue) {
                res = s.substring(l, r + 1);
            }
        }
        return res;
    }
}