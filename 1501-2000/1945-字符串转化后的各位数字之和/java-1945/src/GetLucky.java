class GetLucky {
    public int getLucky(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cur = (s.charAt(i) - 'a') + 1;
            sb.append(cur);
        }
        String str = sb.toString();
        while (k > 0) {
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                res += str.charAt(i) - '0';
            }
            str = String.valueOf(res);
            k--;
        }
        return Integer.valueOf(str);
    }
}