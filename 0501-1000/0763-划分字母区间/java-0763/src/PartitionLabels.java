import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        HashMap<Character, Integer> charIndex = new HashMap<>();
        int[] rightIdx = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (!charIndex.containsKey(s.charAt(i))) {
                charIndex.put(s.charAt(i), i);
                rightIdx[i] = -1;
            } else {
                rightIdx[i] = charIndex.get(s.charAt(i));
            }
        }

        int curRightIdx = -1;
        ArrayList<Integer> res = new ArrayList<>();
        int presum = 0;
        for (int i = 0; i < n; i++) {
            curRightIdx = Math.max(curRightIdx, rightIdx[i]);
            if (curRightIdx <= i) {
                if (res.size() == 0) {
                    res.add(i + 1);
                    presum += i + 1;
                } else {
                    res.add(i - presum + 1);
                    presum += i - presum + 1;
                }
            }
        }
        return res;
    }
}