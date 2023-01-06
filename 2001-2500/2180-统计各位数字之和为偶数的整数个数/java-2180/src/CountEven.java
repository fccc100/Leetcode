class CountEven {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int cur = i;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            if (sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}