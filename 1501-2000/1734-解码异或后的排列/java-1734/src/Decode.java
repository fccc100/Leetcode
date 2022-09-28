class Decode {
    public int[] decode(int[] encoded) {
        int n = encoded.length;

        // 先求所有数的异或
        int t = 0;
        for (int i = 1; i <= n + 1; i++) {
            t ^= i;
        }

        // 求encoded中偶数项的值 跟 t异或的结果就是第一项的值
        // 2^3 ^ 4^5 ^ 6^7 ...
        for (int i = 1; i < encoded.length; i += 2) {
            t ^= encoded[i];
        }

        int[] res = new int[n + 1];
        res[0] = t;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}