import java.util.*;

class MaxStarSum {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        if (k == 0) {
            Arrays.sort(vals);
            return vals[vals.length - 1];
        }

        HashSet<Integer>[] graph = new HashSet[vals.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            for (Integer v : graph[i]) {
                map.get(i).add(vals[v]);
            }
        }

        int res = Integer.MIN_VALUE;
        for (Map.Entry entry : map.entrySet()) {
            ArrayList<Integer> arr = (ArrayList<Integer>) entry.getValue();
            Collections.sort(arr, (a, b) -> b - a);
            int i = 0;
            int cur = vals[(int) entry.getKey()];

            while (i < arr.size() && i < k && arr.get(i) > 0) {
                cur += arr.get(i);
                i++;
            }

            res = Math.max(res, cur);
        }
        return res;
    }
}