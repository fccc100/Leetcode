class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        String t = s1.charAt(s1.length() - 1) + s1.substring(0, s1.length() - 1);
        while (!t.equals(s2)) {
            t = t.charAt(t.length() - 1) + t.substring(0, t.length() - 1);

            if (t.equals(s1)) {
                return false;
            }
        }
        return true;
    }
}