class HammingDistance {
    public int hammingDistance(int x, int y) {
        String s1 = getBits(x);
        String s2 = getBits(y);

        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    private String getBits(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            String cur = (n & (1 << i)) == 0 ? "0" : "1";

            sb.append(cur);
        }

        return sb.toString();
    }
}