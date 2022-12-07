import java.util.ArrayList;
import java.util.HashMap;

class WordDistance {

    HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
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
