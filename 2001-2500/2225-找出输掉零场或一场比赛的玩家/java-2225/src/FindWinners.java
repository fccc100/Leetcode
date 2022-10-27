import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            if (!map.containsKey(winner)) {
                int[] val = new int[2];
                val[0]++;
                map.put(winner, val);
            } else {
                map.get(winner)[0]++;
            }

            if (!map.containsKey(loser)) {
                int[] val = new int[2];
                val[1]++;
                map.put(loser, val);
            } else {
                map.get(loser)[1]++;
            }
        }

        List<Integer> winner = new ArrayList<>();
        List<Integer> loserOne = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int[] cur = map.get(key);
            if (cur[1] == 0) {
                winner.add(key);
            }
            if (cur[1] == 1) {
                loserOne.add(key);
            }
        }

        Collections.sort(winner);
        Collections.sort(loserOne);

        List<List<Integer>> res = new ArrayList<>();
        res.add(winner);
        res.add(loserOne);
        return res;
    }
}