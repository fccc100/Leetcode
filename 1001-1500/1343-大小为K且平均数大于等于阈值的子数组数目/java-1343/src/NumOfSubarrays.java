class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;

        int l = 0;
        int r = k - 1;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }

        int res = 0;
        if (sum / k >= threshold) {
            res++;
        }

        while (r + 1 < n) {
            r++;
            sum += arr[r];

            sum -= arr[l];
            l++;
            if (sum / k >= threshold) {
                res++;
            }
        }
        return res;
    }
}