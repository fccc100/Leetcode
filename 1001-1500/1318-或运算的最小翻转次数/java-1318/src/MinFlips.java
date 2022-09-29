class MinFlips {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            if ((c & (1 << i)) != 0) {
                if ((a & (1 << i)) == 0 && (b & (1 << i)) == 0) {
                    res++;
                }
            } else {
                if ((a & (1 << i)) != 0) {
                    res++;
                }
                if ((b & (1 << i)) != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}