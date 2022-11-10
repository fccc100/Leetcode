import java.util.Arrays;
import java.util.HashMap;

class ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        char maxFreqChar = 'a';
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > maxFreq) {
                maxFreq = map.get(s.charAt(i));
                maxFreqChar = s.charAt(i);
            }
        }

        if (n % 2 == 0 && maxFreq > n / 2) {
            return "";
        }
        if (n % 2 == 1 && maxFreq > n / 2 + 1) {
            return "";
        }

        char[] arr = new char[n];
        int i = 0;

        while (maxFreq > 0) {
            arr[i] = maxFreqChar;
            i += 2;
            maxFreq--;
        }

        char[] strs = s.toCharArray();
        Arrays.sort(strs);

        for (int j = 0; j < n; j++) {
            if (i >= n) i = 1;
            if (strs[j] != maxFreqChar) {
                arr[i] = strs[j];
                i += 2;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int j = 0; j < n; j++) {
            res.append(arr[j]);
        }
        return res.toString();
    }
}