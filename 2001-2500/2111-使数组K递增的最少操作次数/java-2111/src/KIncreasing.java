class KIncreasing {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;

        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l >> 1);

            if (check(arr, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] arr, int c, int k) {
        int n = arr.length;

        int cnt = 0;
        for (int i = 0; i < n - k; i++) {
            if (arr[i] > arr[i + k]) cnt++;
        }
        return cnt <= c;
    }
}
//[12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3] 1
// 5  6 6  6 2  2 13 3

//[12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3]
//                      996       997  998        999    1000