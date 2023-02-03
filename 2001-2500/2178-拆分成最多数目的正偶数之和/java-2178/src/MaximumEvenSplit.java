import java.util.ArrayList;
import java.util.List;

class MaximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return new ArrayList<>();
        long cur = 2;
        List<Long> res = new ArrayList<>();
        while (finalSum >= cur) {
            res.add(cur);
            finalSum -= cur;
            cur += 2;
        }
        if (finalSum == 0) return res;
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }
}