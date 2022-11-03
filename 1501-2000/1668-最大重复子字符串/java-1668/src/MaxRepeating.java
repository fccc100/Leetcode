class MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        String s = word;
        int res = 0;
        while (sequence.indexOf(s) >= 0) {
            s += word;
            res++;
        }
        return res;
    }
}