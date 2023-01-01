class RepeatedCharacter {
    public char repeatedCharacter(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            if (map[s.charAt(i) - 'a'] > 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}