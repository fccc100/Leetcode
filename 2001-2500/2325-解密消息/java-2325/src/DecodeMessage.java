class DecodeMessage {
    public String decodeMessage(String key, String message) {
        int[] map = new int[26];
        int idx = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ') continue;
            if (map[key.charAt(i) - 'a'] != 0) continue;
            map[key.charAt(i) - 'a'] = idx;
            idx++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                res.append(' ');
                continue;
            }
            res.append((char) map[message.charAt(i) - 'a']);
        }
        return res.toString();
    }
}
