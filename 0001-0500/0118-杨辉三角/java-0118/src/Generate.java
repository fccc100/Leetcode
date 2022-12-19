import java.util.*;

class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        f.add(1);
        res.add(f);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}