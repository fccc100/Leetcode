import java.util.HashMap;
import java.util.Map;

class CustomSortString {
    public String customSortString(String order, String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            int cnt = map.getOrDefault(order.charAt(i), 0);
            while (cnt > 0) {
                res.append(order.charAt(i));
                cnt--;
            }
            map.remove(order.charAt(i));
        }

        for (Map.Entry entry : map.entrySet()) {
            int v = (int) entry.getValue();
            char k = (char) entry.getKey();
            while (v > 0) {
                res.append(k);
                v--;
            }
        }
        return res.toString();
    }
}