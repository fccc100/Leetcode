import java.util.Arrays;
import java.util.HashMap;

class MinSetSize {
    public int minSetSize(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] cntArr = new int[map.size()];
        int idx = 0;
        for (Integer i : map.values()) {
            cntArr[idx] = i;
            idx++;
        }

        Arrays.sort(cntArr);
        int res = 0;
        int curCnt = 0;
        for (int i = cntArr.length - 1; i >= 0; i--) {
            curCnt += cntArr[i];
            res++;
            if (curCnt >= Math.ceil(n / 2)) {
                return res;
            }
        }
        return res;
    }
}