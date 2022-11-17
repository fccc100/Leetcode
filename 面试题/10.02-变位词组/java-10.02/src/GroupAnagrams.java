import com.sun.tools.javac.util.List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int  n = strs.length;
        String[] temp = new String[n];

        for (int i = 0; i < n; i++) {
            char[] cur = strs[i].toCharArray();

            Arrays.sort(cur);
            temp[i] = String.copyValueOf(cur);
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], new ArrayList<>());
            }
            map.get(temp[i]).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for (List val : map.values()) {
            res.add(val);
        }
        return res;
    }
}