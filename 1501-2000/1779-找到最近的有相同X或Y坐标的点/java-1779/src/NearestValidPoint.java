class NearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;

        int minDis = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int curDis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);

                if (curDis < minDis) {
                    minDis = curDis;
                    res = i;
                }
            }
        }
        return res;
    }
}