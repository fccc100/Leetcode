import java.util.Arrays;
import java.util.PriorityQueue;

class MaxScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        long sum = 0;
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int min = pairs[i][1];
            int x = pairs[i][0];
            if (pq.size() < k) {
                sum += x;
                pq.offer(x);
                if (pq.size() == k) {
                    res = Math.max(res, min * sum);
                }
            } else {
                if (x > pq.peek()) {
                    sum -= pq.poll();
                    pq.offer(x);
                    sum += x;
                }
                res = Math.max(res, min * sum);
            }
        }
        return res;
    }
}