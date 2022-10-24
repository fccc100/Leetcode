class ReverseWords {
    public void reverseWords(char[] s) {
        int n = s.length;
        int start = 0;
        int end = -1;
        for (int i = 0; i <= n; i++) {
            if (i == n || s[i] == ' ') {
                end = i - 1;
                reverse(s, start, end);
                start = i + 1;
            }
        }
        reverse(s, 0, n - 1);
    }
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}