class FindingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int n = logs.length;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = logs[i][0];
            int time = logs[i][1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<Integer>());
            }
            map.get(id).add(time);
        }
        int[] res = new int[k];
        for (Set<Integer> set : map.values()) {
            res[set.size() - 1]++;
        }
        return res;
    }
}