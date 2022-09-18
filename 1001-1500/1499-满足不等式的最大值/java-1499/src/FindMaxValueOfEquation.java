import java.util.Deque;
import java.util.LinkedList;

class FindMaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;

        int res = Integer.MIN_VALUE;
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(points[0]);

        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && points[i][0] - queue.peekFirst()[0] > k) {
                queue.pollFirst();
            }

            if (!queue.isEmpty()) {
                res = Math.max(res, queue.peekFirst()[1] + points[i][1] + points[i][0] - queue.peekFirst()[0]);
            }

            while (!queue.isEmpty() && points[i][1] - points[i][0] >= queue.peekLast()[1] - queue.peekLast()[0]) {
                queue.pollLast();
            }
            queue.offerLast(points[i]);
        }
        return res;
    }
}