import java.util.HashMap;

class SubstringXorQueries {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (!map.containsKey(0)) {
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            StringBuilder cur = new StringBuilder();
            for (int j = i; j < Math.min(i + 31, n); j++) {
                cur.append(s.charAt(j));
                int t = Integer.parseInt(cur.toString(), 2);
                if (!map.containsKey(t)) {
                    map.put(t, new int[]{i, j});
                }
            }
        }

        int[][] res = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int t = queries[i][0] ^ queries[i][1];
            if (!map.containsKey(t)) {
                res[i] = new int[]{-1, -1};
            } else {
                res[i] = map.get(t);
            }
        }
        return res;
    }
}