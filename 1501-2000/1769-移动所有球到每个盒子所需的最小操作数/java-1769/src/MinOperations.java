class MinOperations {
    // O(n^2)
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    res[i] += j - i;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (boxes.charAt(j) == '1') {
                    res[i] += i - j;
                }
            }
        }
        return res;
    }
}