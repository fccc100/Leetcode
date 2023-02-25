import java.util.*;

class ValidArrangement {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, int[]> degree = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            graph.get(x).add(y);
            if (!degree.containsKey(x)) {
                degree.put(x, new int[]{0, 0});
            }
            degree.get(x)[0]++;
            if (!degree.containsKey(y)) {
                degree.put(y, new int[]{0, 0});
            }
            degree.get(y)[1]++;
        }

        int start = pairs[0][0];
        for (Map.Entry entry : degree.entrySet()) {
            int v = (int) entry.getKey();
            int[] d = (int[]) entry.getValue();
            if (d[0] - d[1] == 1) {
                start = v;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int curV = stack.peek();
            if (graph.containsKey(curV) && graph.get(curV).size() != 0) {
                List<Integer> edges = graph.get(curV);
                int w = edges.get(edges.size() - 1);
                edges.remove(edges.size() - 1);
                stack.push(w);
            } else {
                res.add(stack.pop());
            }
        }

        Collections.reverse(res);
        int[][] ans = new int[res.size() - 1][2];
        for (int i = 0; i < res.size() - 1; i++) {
            ans[i] = new int[]{res.get(i), res.get(i + 1)};
        }
        return ans;
    }
}