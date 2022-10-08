import java.util.Arrays;

class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Integer[] temp = new Integer[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums1[i];
            idx[i] = i;
        }

        Arrays.sort(temp, (a, b) -> a - b);
        Arrays.sort(idx, (a, b) -> nums2[a] - nums2[b]);

        int[] res = new int[n];
        int i = 0;
        int j = 0;
        int endIndex = n - 1;
        while (i < n) {
            if (temp[i] > nums2[idx[j]]) {
                res[idx[j]] = temp[i];
                i++;
                j++;
            } else {
                res[idx[endIndex]] = temp[i];
                endIndex--;
                i++;
            }
        }
        return res;
    }
}