import java.util.HashMap;
import java.util.Map;

class LargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;

        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curLen = 1;
            for (int j = 0; j < messages[i].length(); j++) {
                if (messages[i].charAt(j) == ' ') {
                    curLen++;
                }
            }

            map.put(senders[i], map.getOrDefault(senders[i], 0) + curLen);
            max = Math.max(max, map.get(senders[i]));
        }

        String res = "";
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == max) {
                if (res.length() == 0) {
                    res = (String) entry.getKey();
                } else {
                    if (((String) entry.getKey()).compareTo(res) > 0) {
                        res = (String) entry.getKey();
                    }
                }
            }
        }
        return res;
    }
}