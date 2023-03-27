import java.util.HashSet;

class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(Integer.parseInt(sub, 2));
        }
        int cnt = (int) Math.pow(2, k);
        return set.size() == cnt;
    }
}