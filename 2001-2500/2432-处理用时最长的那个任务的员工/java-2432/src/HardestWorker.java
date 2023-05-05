import java.util.Arrays;

class HardestWorker {
    public int hardestWorker(int n, int[][] logs) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < logs.length; i++) {
            int cur = logs[i][1] - end;

            if (cur > max) {
                max = cur;
                res = logs[i][0];
            }
            if (cur == max) {
                if (logs[i][0] < res) {
                    res = logs[i][0];
                }
            }
            end = logs[i][1];
        }
        return res;
    }
}