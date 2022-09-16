import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class MinJumps {
    public int minJumps(int[] arr) {
        int n = arr.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        visited[0] = true;

        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll();

                if (cur == n - 1) {
                    return res;
                }

                if (cur + 1 < n && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    queue.offer(cur + 1);
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    queue.offer(cur - 1);
                }

                ArrayList<Integer> path = map.getOrDefault(arr[cur], new ArrayList<>());
                for (int j = 0; j < path.size(); j++) {
                    if (path.get(j) == cur) {
                        continue;
                    }
                    if (!visited[path.get(j)]) {
                        visited[path.get(j)] = true;
                        queue.offer(path.get(j));
                    }
                }
                path.clear();
            }

            res++;
        }

        return res;
    }
}