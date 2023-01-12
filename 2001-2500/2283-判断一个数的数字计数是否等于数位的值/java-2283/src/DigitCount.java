class DigitCount {
    public boolean digitCount(String num) {
        int[] map = new int[10];
        for (int i = 0; i < num.length(); i++) {
            map[num.charAt(i) - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            if (map[i] != (num.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }
}