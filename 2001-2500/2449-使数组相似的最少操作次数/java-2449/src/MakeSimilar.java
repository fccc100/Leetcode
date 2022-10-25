import java.util.ArrayList;
import java.util.Collections;

class MakeSimilar {
    public long makeSimilar(int[] nums, int[] target) {
        int n = nums.length;

        ArrayList<Integer> tempNums = new ArrayList<>();
        ArrayList<Integer> tempTarget = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                tempNums.add(nums[i]);
            }
            if (target[i] % 2 == 0) {
                tempTarget.add(target[i]);
            }
        }

        long res = 0;
        Collections.sort(tempNums);
        Collections.sort(tempTarget);
        for (int i = 0; i < tempNums.size(); i++) {
            res += Math.abs(tempNums.get(i) - tempTarget.get(i));
        }

        tempNums.clear();
        tempTarget.clear();
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                tempNums.add(nums[i]);
            }
            if (target[i] % 2 == 1) {
                tempTarget.add(target[i]);
            }
        }

        Collections.sort(tempNums);
        Collections.sort(tempTarget);
        for (int i = 0; i < tempNums.size(); i++) {
            res += Math.abs(tempNums.get(i) - tempTarget.get(i));
        }

        return res / 4;
    }
}