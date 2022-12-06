import java.util.HashSet;

class NumDifferentIntegers {
    public int numDifferentIntegers(String word) {
        int n = word.length();

        HashSet<String> set = new HashSet<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(word.charAt(i))) {
                cur.append(word.charAt(i));
            } else {
                if (cur.length() > 0) {
                    int j = 0;
                    while (j < cur.length() && cur.charAt(j) == '0') {
                        j++;
                    }
                    if (j >= cur.length()) {
                        set.add("0");
                    } else {
                        set.add(cur.substring(j).toString());
                    }
                    cur.delete(0, cur.length());
                }
            }
        }
        if (cur.length() > 0) {
            int j = 0;
            while (j < cur.length() && cur.charAt(j) == '0') {
                j++;
            }
            if (j >= cur.length()) {
                set.add("0");
            } else {
                set.add(cur.substring(j).toString());
            }
        }
        return set.size();
    }
}