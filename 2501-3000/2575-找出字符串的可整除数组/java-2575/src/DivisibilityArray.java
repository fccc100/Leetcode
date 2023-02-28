class DivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        String cur = "";
        for (int i = 0; i < n; i++) {
            cur += word.charAt(i);
            if (Long.valueOf(cur) % m == 0) {
                res[i] = 1;
            }

            cur = String.valueOf(Long.valueOf(cur) % m);
        }
        return res;
    }
}