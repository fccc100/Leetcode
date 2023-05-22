public class makeSmallestPalindrome2 {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char l = arr[i], r = arr[n - 1 - i];
            if (l > r) arr[i] = r;
            else arr[n - 1 - i] = l;
        }

        return new String(arr);
    }
}
