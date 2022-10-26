class WaysToBuyPensPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int max = total / cost1;

        long res = 0;
        for (int i = 0; i <= max; i++) {
            int left = total - (i * cost1);

            int ways2 = left / cost2 + 1;

            res += ways2;
        }
        return res;
    }
}