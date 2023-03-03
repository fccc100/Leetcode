import java.util.HashSet;

// TLE
class GetFolderNames {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(names[i])) {
                set.add(names[i]);
                res[i] = names[i];
            } else {
                int idx = 1;
                while (set.contains(names[i] + "(" + idx + ")")) {
                    idx++;
                }
                String s = names[i] + "(" + idx + ")";
                set.add(s);
                res[i] = s;
            }
        }
        return res;
    }
}