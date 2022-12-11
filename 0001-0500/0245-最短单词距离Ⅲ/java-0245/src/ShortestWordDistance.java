import java.util.ArrayList;
import java.util.HashMap;

class ShortestWordDistance {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }

        if (word1.equals(word2)) {
            ArrayList<Integer> l = map.get(word1);
            int res = n;
            for (int i = 1; i < l.size(); i++) {
                res = Math.min(res, l.get(i) - l.get(i - 1));
            }
            return res;
        } else {
            ArrayList<Integer> l1 = map.get(word1);
            ArrayList<Integer> l2 = map.get(word2);
            int i = 0;
            int j = 0;
            int res = n;
            while (i < l1.size() && j < l2.size()) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}