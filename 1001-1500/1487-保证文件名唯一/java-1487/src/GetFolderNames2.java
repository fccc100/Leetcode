import java.util.HashMap;
import java.util.HashSet;

public class GetFolderNames2 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> minIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(names[i])) {
                set.add(names[i]);
                res[i] = names[i];
            } else {
                int idx = minIdx.getOrDefault(names[i], 1);
                while (set.contains(names[i] + "(" + idx + ")")) {
                    idx++;
                }
                String s = names[i] + "(" + idx + ")";
                set.add(s);
                minIdx.put(names[i], idx + 1);
                res[i] = s;
            }
        }
        return res;
    }
}
