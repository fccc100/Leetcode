import java.util.Arrays;
import java.util.LinkedList;

class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][2];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.removeFirst();
            i++;
        }
        return res;
    }
}