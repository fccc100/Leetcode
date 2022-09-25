import java.util.LinkedList;
import java.util.Queue;

class MinJump {
    public int minJump(int[] jump) {
        int n = jump.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        int res = 0;
        int maxIndex = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll();

                if (cur + jump[cur] >= n) {
                    return res + 1;
                }

                if (!visited[cur + jump[cur]]) {
                    queue.offer(cur + jump[cur]);
                    visited[cur + jump[cur]] = true;
                }

                for (int j = maxIndex; j < cur; j++) {
                    if (!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }

                maxIndex = Math.max(maxIndex, cur);
            }
            res ++;
        }
        return -1;
    }
}