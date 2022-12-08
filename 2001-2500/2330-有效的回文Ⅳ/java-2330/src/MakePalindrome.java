class MakePalindrome {
    public boolean makePalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        int cnt = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                cnt++;
            }
            if (cnt > 2) return false;
            l++;
            r--;
        }
        return true;
    }
}