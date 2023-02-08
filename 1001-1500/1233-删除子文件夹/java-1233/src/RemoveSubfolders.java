import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder);

        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        int prevIdx = 0;
        for (int i = 1; i < n; i++) {
            String s = folder[i];
            String prev = folder[prevIdx];
            if (s.startsWith(prev) && s.charAt(prev.length()) == '/') {

            } else {
                res.add(s);
                prevIdx = i;
            }
        }
        return res;
    }
}