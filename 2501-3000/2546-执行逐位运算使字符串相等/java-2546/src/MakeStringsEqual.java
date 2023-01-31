class MakeStringsEqual {
    public boolean makeStringsEqual(String s, String target) {
        int n = s.length();
        boolean sHasOne = false;
        boolean tHasOne = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') sHasOne = true;
            if (target.charAt(i) == '1') tHasOne = true;
        }

        if (!sHasOne && !tHasOne) return true;
        if (sHasOne && tHasOne) return true;
        return false;
    }
}