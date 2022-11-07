import java.util.Arrays;
import java.util.PriorityQueue;

class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        int l = 0;
        PriorityQueue<Integer> lPQ = new PriorityQueue<>();
        while (l < candidates) {
            lPQ.offer(costs[l]);
            l++;
        }
        l--;

        int r = n - 1;
        PriorityQueue<Integer> rPQ = new PriorityQueue<>();
        while (n - r < candidates + 1) {
            if (r <= l) break;
            rPQ.offer(costs[r]);
            r--;
        }
        r++;

        long res = 0;
        while (k > 0) {
            int cur = 0;

            if (lPQ.isEmpty() || rPQ.isEmpty()) {
                if (lPQ.isEmpty()) {
                    cur = rPQ.poll();
                } else {
                    cur = lPQ.poll();
                }
                res += cur;
                k--;
                continue;
            }

            int lMin = lPQ.peek();
            int rMin = rPQ.peek();
            if (l >= r) {
                if (lMin > rMin) {
                    cur = rPQ.poll();
                } else {
                    cur = lPQ.poll();
                }
            } else {
                if (lMin > rMin) {
                    cur = rPQ.poll();
                    r--;
                    if (r > l) {
                        rPQ.offer(costs[r]);
                    }
                } else {
                    cur = lPQ.poll();
                    l++;
                    if (l < r) {
                        lPQ.offer(costs[l]);
                    }
                }
            }

            res += cur;
            k--;
        }
        return res;
    }
}