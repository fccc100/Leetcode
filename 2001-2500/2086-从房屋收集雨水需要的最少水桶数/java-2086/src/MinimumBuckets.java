import java.util.HashSet;

class MinimumBuckets {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            char c = hamsters.charAt(i);
            if (c == '.') {
                if (hamsters.charAt(i - 1) == 'H' && hamsters.charAt(i + 1) == 'H') {
                    if (!set.contains(i - 1) && !set.contains(i + 1)) {
                        res ++;
                        set.add(i - 1);
                        set.add(i + 1);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            char c = hamsters.charAt(i);
            if (c == 'H') {
                if (i == 0 && i + 1 >= n) return -1;
                if (i == 0 && hamsters.charAt(i + 1) == 'H') return -1;
                if (i == n - 1 && hamsters.charAt(n - 2) == 'H') return -1;
                if (i >= 1 && i < n - 1) {
                    if (hamsters.charAt(i - 1) == 'H' && hamsters.charAt(i + 1) == 'H') return -1;
                }
                if (!set.contains(i)) {
                    res++;
                    set.add(i);
                }
            }
        }
        return res;
    }
}