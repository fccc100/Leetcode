import java.util.ArrayList;
import java.util.List;

class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        int m = target.length;
        ArrayList<String> res = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < m;) {
            if (target[i] == index) {
                res.add("Push");
                i++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
            index++;
        }
        return res;
    }
}