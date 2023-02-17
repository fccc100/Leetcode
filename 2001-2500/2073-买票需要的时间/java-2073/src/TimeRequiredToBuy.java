class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int res = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    res++;
                    tickets[i]--;
                }
                if (i == k && tickets[i] == 0) {
                    return res;
                }
            }
        }
    }
}