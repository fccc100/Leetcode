class CheckIfPangram {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) return false;
        }
        return true;
    }
}