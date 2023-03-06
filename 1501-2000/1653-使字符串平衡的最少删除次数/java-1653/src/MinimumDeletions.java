class MinimumDeletions {
    public int minimumDeletions(String s) {
        int n = s.length();
        int rightA = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }

        int leftB = 0;
        int res = rightA;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            res = Math.min(res, leftB + rightA);
        }
        return res;
    }
}