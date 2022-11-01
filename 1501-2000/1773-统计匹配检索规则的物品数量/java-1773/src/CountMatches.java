import java.util.List;

class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int n = items.size();

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ruleKey.equals("type") && ruleValue.equals(items.get(i).get(0))) {
                res++;
            }

            if (ruleKey.equals("color") && ruleValue.equals(items.get(i).get(1))) {
                res++;
            }
            if (ruleKey.equals("name") && ruleValue.equals(items.get(i).get(2))) {
                res++;
            }
        }
        return res;
    }
}