class NextBeautifulNumber {
    public int nextBeautifulNumber(int n) {
        int i = n + 1;
        while (true) {
            if (check(i)) {
                return i;
            }
            i++;
        }
    }
    private boolean check(int n) {
        int[] map = new int[10];
        while (n > 0) {
            int k = n % 10;
            map[k]++;
            n /= 10;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 && i != map[i]) return false;
        }
        return true;
    }
}