class ClosetTarget {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                res = Math.min(res, Math.abs(startIndex - i));
                if (startIndex < i) {
                    res = Math.min(res, startIndex + n - i);
                }
                if (startIndex > i) {
                    res = Math.min(res, i + n - startIndex);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}