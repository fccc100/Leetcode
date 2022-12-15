import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class WordBreak {
    List<String> res;
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        tryBreak(s, 0, "");
        return res;
    }
    private void tryBreak(String s, int startIdx, String curStr) {
        if (startIdx >= s.length()) {
            res.add(curStr);
            return;
        }

        StringBuilder cur = new StringBuilder();
        for (int i = startIdx; i < s.length(); i++) {
            cur.append(s.charAt(i));

            if (set.contains(cur.toString())) {
                String temp = "";
                if (curStr.length() > 0) {
                    temp = curStr + " " + cur.toString();
                } else {
                    temp = curStr + cur.toString();
                }
                tryBreak(s, i + 1, temp);
            }
        }
    }
}