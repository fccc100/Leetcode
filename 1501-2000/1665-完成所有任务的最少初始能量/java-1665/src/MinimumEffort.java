import java.util.Arrays;

class MinimumEffort {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> {
            if (a[1] - a[0] < b[1] - b[0]) {
                return -1;
            } else if (a[1] - a[0] == b[1] - b[0]) {
                return 0;
            } else {
                return 1;
            }
        });

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res + tasks[i][0], tasks[i][1]);
        }
        return res;
    }
}