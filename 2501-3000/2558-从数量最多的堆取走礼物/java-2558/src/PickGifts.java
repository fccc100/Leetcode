import java.util.PriorityQueue;

class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.offer(gifts[i]);
        }
        while (k > 0) {
            int top = pq.poll();
            pq.offer((int) Math.floor(Math.sqrt(top)));
            k--;
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}