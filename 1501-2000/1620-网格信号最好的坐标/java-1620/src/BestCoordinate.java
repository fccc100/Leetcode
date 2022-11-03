class BestCoordinate {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            int x = tower[0], y = tower[1];
            xMax = Math.max(xMax, x);
            yMax = Math.max(yMax, y);
        }
        int cx = 0, cy = 0;
        int max = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                int[] c = {x, y};
                int q = 0;
                for (int[] tower : towers) {
                    int d = (tower[0] - c[0]) * (tower[0] - c[0]) + (tower[1] - c[1]) * (tower[1] - c[1]);
                    if (d <= radius * radius) {
                        double t = Math.sqrt(d);
                        q += (int) Math.floor(tower[2] / (1 + t));
                    }
                }
                if (q > max) {
                    cx = x;
                    cy = y;
                    max = q;
                }
            }
        }
        return new int[]{cx, cy};
    }
}