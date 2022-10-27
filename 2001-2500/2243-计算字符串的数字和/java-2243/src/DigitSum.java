class DigitSum {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder newS = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                int cur = 0;
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    cur += s.charAt(j) - '0';
                }

                newS.append(cur);
            }
            s = newS.toString();
        }
        return s;
    }
}