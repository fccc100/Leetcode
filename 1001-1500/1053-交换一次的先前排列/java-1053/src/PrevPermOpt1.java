class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int last = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                last = i;
                break;
            }
        }
        if (last == -1) return arr;
        int maxIdx = -1;
        int max = -1;
        for (int i = last + 1; i < n; i++) {
            if (arr[i] < arr[last]) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
        }
        int temp = arr[last];
        arr[last] = arr[maxIdx];
        arr[maxIdx] = temp;
        return arr;
    }
}