import java.util.HashSet;

class FindDifferentBinaryString {
    HashSet<String> set;
    String res;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        set = new HashSet<>();
        res = "-1";
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        dfs("", n, 0);
        return res;
    }

    private void dfs(String s, int n, int index) {
        if (index == n) {
            if (!set.contains(s)) {
                res = s;
                return;
            }
            return;
        }

        if ("-1".equals(res)) {
            dfs(s + "0", n, index + 1);
            dfs(s + "1", n, index + 1);
        }
    }
}