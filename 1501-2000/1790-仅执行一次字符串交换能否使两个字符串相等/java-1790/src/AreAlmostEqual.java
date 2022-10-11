class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        int diff1 = -1;
        int diff2 = -1;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff1 < 0) {
                    diff1 = i;
                } else if (diff2 < 0) {
                    diff2 = i;
                } else {
                    return false;
                }
            }
        }

        if (diff2 < 0) return false;
        if (s1.charAt(diff1) == s2.charAt(diff2) && s1.charAt(diff2) == s2.charAt(diff1)) {
            return true;
        }
        return false;
    }
}