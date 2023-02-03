import java.util.HashMap;

class InterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        HashMap<Double, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            double cur = (double) rectangles[i][0] / rectangles[i][1];
            res += map.getOrDefault(cur, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}