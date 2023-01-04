class TakeCharacters {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] totalCnt = new int[3];
        for (int i = 0; i < s.length(); i++) {
            totalCnt[s.charAt(i) - 'a']++;
        }
        if (totalCnt[0] < k || totalCnt[1] < k || totalCnt[2] < k) {
            return -1;
        }

        int[] curCnt = new int[3];
        int l = 0;
        int r = -1;
        int max = -1;
        while (r < n) {
            int a = totalCnt[0] - curCnt[0];
            int b = totalCnt[1] - curCnt[1];
            int c = totalCnt[2] - curCnt[2];
            if (a >= k && b >= k && c >= k) {
                max = Math.max(max, r - l + 1);
                r++;
                if (r >= n) break;

                curCnt[s.charAt(r) - 'a']++;
            } else {
                curCnt[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return n - max;
    }
}