class IsCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;

        char cur = arr[0].charAt(arr[0].length() - 1);

        for (int i = 1; i < n; i++) {
            String s = arr[i];
            if (s.charAt(0) != cur) {
                return false;
            }
            cur = s.charAt(s.length() - 1);
        }
        return arr[0].charAt(0) == cur;
    }
}