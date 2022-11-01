class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }
    private String join(String[] s) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            res.append(s[i]);
        }
        return res.toString();
    }
}