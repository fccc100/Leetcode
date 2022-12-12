class MaximumValue {
    public int maximumValue(String[] strs) {
        int n = strs.length;

        int res = -1;
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            boolean isDigit = true;
            for (int j = 0; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j))) {
                    isDigit = false;
                }
            }
            if (isDigit) {
                res = Math.max(res, Integer.valueOf(s));
            } else {
                res = Math.max(res, s.length());
            }
        }
        return res;
    }
}