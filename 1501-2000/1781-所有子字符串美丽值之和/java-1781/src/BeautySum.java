class BeautySum {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] map = new int[26];
            for (int j = i; j >= 0; j--) {
                map[s.charAt(j) - 'a']++;

                int min = s.length();
                int max = 0;
                for (int k = 0; k < 26; k++) {
                    if (map[k] > 0) {
                        min = Math.min(min, map[k]);
                        max = Math.max(max, map[k]);
                    }
                }

                if (min > 0 && max > 0 && max - min > 0) {
                    res += max - min;
                }
            }
        }
        return res;
    }
}