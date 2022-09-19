class CountDaysTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (arriveAlice.compareTo(leaveBob) > 0 || arriveBob.compareTo(leaveAlice) > 0) return 0;
        if (arriveAlice.compareTo(leaveBob) == 0 || arriveBob.compareTo(leaveAlice) == 0) return 1;

        String maxArrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String minLeave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        int m1 = Integer.valueOf(maxArrive.split("-")[0]);
        int d1 = Integer.valueOf(maxArrive.split("-")[1]);

        int m2 = Integer.valueOf(minLeave.split("-")[0]);
        int d2 = Integer.valueOf(minLeave.split("-")[1]);

        if (m1 == m2) {
            return d2 - d1 + 1;
        }

        int res = 0;
        res += (days[m1 - 1] - d1 + 1);
        for (int i = m1 + 1; i < m2; i++) {
            res += days[i - 1];
        }
        res += d2;
        return res;
    }
}