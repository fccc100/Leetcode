class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[]{};
        Arrays.sort(changed);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[] res = new int[n / 2];
        int idx = 0;
        for (int x : changed) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) {
                    map.remove(x);
                }
                if (map.containsKey(2 * x)) {
                    res[idx] = x;
                    idx++;
                    map.put(2 * x, map.get(2 * x) - 1);
                    if (map.get(2 * x) == 0) {
                        map.remove(2 * x);
                    }
                }
            }
        }
        if (idx < n / 2) return new int[]{};
        return res;
    }
}