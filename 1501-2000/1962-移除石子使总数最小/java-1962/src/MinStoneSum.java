import java.util.Comparator;
import java.util.PriorityQueue;

class MinStoneSum {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 / 2 - o1 / 2;
            }
        });

        int sum = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(piles[i]);
            sum += piles[i];
        }

        int d = 0;
        while (k > 0) {
            int top = pq.poll();
            d += top / 2;
            pq.offer(top - top / 2);
            k--;
        }

        return sum - d;
    }
}