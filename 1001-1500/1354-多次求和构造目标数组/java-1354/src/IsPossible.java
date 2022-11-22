import java.util.PriorityQueue;

class IsPossible {
    public boolean isPossible(int[] target) {
        int n = target.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(target[i]);
            sum += target[i];
        }

        while (pq.peek() > 1) {
            long top = pq.poll();
            sum -= top;
            long left = sum;
            if (top - left < 1 || left == 0) return false;
            long prev = 0;
            if (top >= 2 * left) {
                prev = top % left;
                if (prev == 0) {
                    prev = left;
                }
            } else {
                prev = top - left;
            }
            pq.offer((int) prev);
            sum += prev;
        }
        return true;
    }
}