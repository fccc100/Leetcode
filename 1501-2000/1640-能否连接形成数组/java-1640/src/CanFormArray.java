import java.util.HashMap;

class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }

            int idx = map.get(arr[i]);

            int tempIdx = i;
            for (int j = 0; j < pieces[idx].length; j++) {
                if (arr[tempIdx] != pieces[idx][j]) {
                    return false;
                } else {
                    tempIdx++;
                }
            }

            i += pieces[idx].length;
        }

        return true;
    }
}