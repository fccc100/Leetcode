import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MostPopularCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;

        HashMap<String, Long> map = new HashMap<>();
        long max = -1;
        HashMap<String, Integer> maxMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String c = creators[i];
            if (!map.containsKey(c)) {
                map.put(c, (long) views[i]);
                maxMap.put(c, i);
            } else {
                map.put(c, map.get(c) + views[i]);

                if (views[i] > views[maxMap.get(c)]) {
                    maxMap.put(c, i);
                }
                if (views[i] == views[maxMap.get(c)]) {
                    if (ids[i].compareTo(ids[maxMap.get(c)]) < 0) {
                        maxMap.put(c, i);
                    }
                }
            }

            max = Math.max(max, map.get(c));
        }

        ArrayList<String> maxC = new ArrayList<>();
        for(Map.Entry entry : map.entrySet()){
            if((long) entry.getValue() == max){
                maxC.add((String) entry.getKey());
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < maxC.size(); i++){
            List<String> cur = new ArrayList<>();
            cur.add(maxC.get(i));
            cur.add(ids[maxMap.get(maxC.get(i))]);
            res.add(cur);
        }
        return res;
    }
}