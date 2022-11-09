import java.util.PriorityQueue;

class ConnectSticks {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sticks[i]);
        }

        int res = 0;
        while (pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();

            res += f + s;
            pq.offer(f + s);
        }
        return res;
    }
}