import java.util.Comparator;
import java.util.PriorityQueue;

class MaximumScore {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        int res = 0;
        while (true) {
            int t1 = pq.poll();
            int t2 = pq.poll();

            if (t1 <= 0 || t2 <= 0) {
                break;
            }

            t1--;
            t2--;
            pq.offer(t1);
            pq.offer(t2);
            res++;
        }
        return res;
    }
}