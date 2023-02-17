public class MinimumBuckets2 {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int res = 0;
        int last = -1;
        for (int i = 0; i < n; i++) {
            char c = hamsters.charAt(i);
            if (c == 'H') {
                if (i == 0) {
                    if (i + 1 >= n) {
                        return -1;
                    }
                    if (hamsters.charAt(i + 1) == 'H') {
                        return -1;
                    } else {
                        res += 1;
                        last = 2;
                    }
                }
                if (i == n - 1) {
                    if (i - 1 >= 0) {
                        if (hamsters.charAt(n - 2) == 'H') {
                            return -1;
                        } else {
                            if (last < i) {
                                res += 1;
                                last = i;
                            }
                        }
                        if (last < i) return -1;
                    }
                }
                if (i <= last) continue;
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    res += 1;
                    last = i + 2;
                } else if (hamsters.charAt(i - 1) == '.') {
                    res += 1;
                    last = i;
                } else return -1;
            }
        }
        return res;
    }
}
