import java.util.PriorityQueue;
import java.util.Queue;

class FindScore {
    public long findScore(int[] nums) {
        int n = nums.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] - b[0] > 0) {
                return 1;
            } else if (a[0] - b[0] < 0) {
                return -1;
            } else {
                return a[1] - b[1];
            }
        });

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long res = 0;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int idx = t[1];
            if (visited[idx]) continue;
            res += t[0];
            visited[idx] = true;
            if (idx - 1 >= 0) {
                visited[idx - 1] = true;
            }
            if (idx + 1 < n) {
                visited[idx + 1] = true;
            }
        }
        return res;
    }
}