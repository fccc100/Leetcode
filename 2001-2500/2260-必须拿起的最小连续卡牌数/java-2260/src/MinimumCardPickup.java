import java.util.HashMap;

class MinimumCardPickup {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                res = Math.min(res, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}