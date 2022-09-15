class MissingNumber {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = ((arr[0] + arr[n - 1]) * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            sum -= arr[i];
        }
        return sum;
    }
}