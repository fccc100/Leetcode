class MaxWidthOfVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}