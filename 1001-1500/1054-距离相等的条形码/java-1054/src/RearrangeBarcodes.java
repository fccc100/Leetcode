import java.util.Arrays;
import java.util.HashMap;

class RearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        Arrays.sort(barcodes);

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxFreqVal = 0;
        for (int i = 0; i < n; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
            if (map.get(barcodes[i]) > maxFreq) {
                maxFreq = map.get(barcodes[i]);
                maxFreqVal = barcodes[i];
            }
        }

        int[] res = new int[n];
        int i = 0;
        while (maxFreq > 0) {
            res[i] = maxFreqVal;
            i += 2;
            maxFreq--;
        }

        for (int j = 0; j < n; j++) {
            if (barcodes[j] != maxFreqVal) {
                if (i >= n) {
                    i = 1;
                }
                res[i] = barcodes[j];
                i += 2;
            }
        }
        return res;
    }
}
