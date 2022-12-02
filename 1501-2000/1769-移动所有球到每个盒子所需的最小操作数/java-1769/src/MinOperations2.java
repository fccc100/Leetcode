public class MinOperations2 {
    // O(n)
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] res = new int[n];
        int preOne = 0;
        int preStep = 0;
        for (int i = 0; i < n; i++) {
            preStep += preOne;
            res[i] += preStep;
            if (boxes.charAt(i) == '1') {
                preOne++;
            }
        }
        int sufOne = 0;
        int sufStep = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufStep += sufOne;
            res[i] += sufStep;
            if (boxes.charAt(i) == '1') {
                sufOne++;
            }
        }
        return res;
    }
}
