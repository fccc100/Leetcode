import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            List<Integer> cur = new ArrayList<>();
            cur.add((int) entry.getKey());
            cur.add((int) entry.getValue());
            res.add(cur);
        }
        return res;
    }
}