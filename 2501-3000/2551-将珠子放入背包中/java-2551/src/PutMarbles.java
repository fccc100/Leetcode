import java.util.PriorityQueue;

class PutMarbles {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int cnt = k - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < n; i++) {
            int x = weights[i - 1];
            int y = weights[i];
            pq1.offer(x + y);
            pq2.offer(x + y);
        }
        long min = weights[0] + weights[n - 1];
        while (cnt > 0) {
            min += pq1.poll();
            cnt--;
        }
        long max = weights[0] + weights[n - 1];
        cnt = k - 1;
        while (cnt > 0) {
            max += pq2.poll();
            cnt--;
        }
        return max - min;
    }
}