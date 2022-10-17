import java.util.HashMap;

class TotalFruit {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = -1;

        int res = 0;
        while (r < n) {
            if (map.size() <= 2) {
                res = Math.max(res, r - l + 1);
                r++;
                if (r >= n) break;
                map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            } else {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
        }
        return res;
    }
}