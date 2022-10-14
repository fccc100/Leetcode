class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] preMax = new int[n];
        preMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], arr[i]);
        }

        int[] nextMin = new int[n];
        nextMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            nextMin[i] = Math.min(nextMin[i + 1], arr[i]);
        }

        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            if (preMax[i] <= nextMin[i + 1]) {
                res++;
            }
        }
        return res;
    }
}