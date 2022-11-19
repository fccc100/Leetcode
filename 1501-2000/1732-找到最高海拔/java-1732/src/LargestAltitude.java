class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int pre = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            pre += gain[i];
            res = Math.max(res, pre);
        }
        return res;
    }
}