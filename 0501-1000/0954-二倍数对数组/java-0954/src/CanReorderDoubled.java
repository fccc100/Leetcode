class CanReorderDoubled {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCnt++;
                continue;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        if (zeroCnt % 2 == 1) return false;

        List<Integer> vals = new ArrayList<Integer>();
        for (int k : map.keySet()) {
            vals.add(k);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int i = 0; i < vals.size(); i++) {
            int x = vals.get(i);
            if (x == 0) continue;

            if (map.getOrDefault(2 * x, 0) < map.get(x)) {
                return false;
            }
            map.put(2 * x, map.getOrDefault(2 * x, 0) - map.get(x));
        }
        return true;
    }
}