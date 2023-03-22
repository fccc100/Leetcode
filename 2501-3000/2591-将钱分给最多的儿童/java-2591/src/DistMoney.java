class DistMoney {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        money -= children;
        int res = 0;
        for (int i = 1; i <= children; i++) {
            if (money >= 7) {
                money -= 7;
                res++;
            }
        }
        if (res == children && money > 0) return res - 1;
        if (res == children - 1 && money == 3) return res - 1;
        return res;
    }
}