import java.util.HashMap;

class GetDistances {
    public long[] getDistances(int[] arr) {
        int n = arr.length;

        long[] leftDp = new long[n];
        HashMap<Integer, Integer> posMap = new HashMap<>();
        HashMap<Integer, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (posMap.containsKey(arr[i])) {
                int cnt = cntMap.get(arr[i]);
                int leftIdx = posMap.get(arr[i]);

                leftDp[i] = Math.abs(i - leftIdx) * cnt + leftDp[leftIdx];
            }

            posMap.put(arr[i], i);
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) + 1);
        }

        long[] rightDp = new long[n];
        posMap.clear();
        cntMap.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (posMap.containsKey(arr[i])) {
                int cnt = cntMap.get(arr[i]);
                int rightIdx = posMap.get(arr[i]);

                rightDp[i] = Math.abs(i - rightIdx) * cnt + rightDp[rightIdx];
            }

            posMap.put(arr[i], i);
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            leftDp[i] += rightDp[i];
        }
        return leftDp;
    }
}