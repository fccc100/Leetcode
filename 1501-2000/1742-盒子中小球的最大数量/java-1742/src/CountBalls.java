class CountBalls {
    public int countBalls(int lowLimit, int highLimit) {
        int[] map = new int[100];
        for (int i = lowLimit; i <= highLimit; i++) {
            String s = String.valueOf(i);

            map[sum(s)]++;
        }
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            res = Math.max(res, map[i]);
        }
        return res;
    }
    private int sum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        return res;
    }
}