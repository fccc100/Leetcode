import java.util.HashMap;
import java.util.Map;

class BestHand {
    public String bestHand(int[] ranks, char[] suits) {
        String[] p = new String[]{"Flush", "Three of a Kind", "Pair", "High Card"};

        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) {
            return p[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        if (max >= 3) return p[1];
        else if (max == 2) return p[2];
        else return p[3];
    }
}