import java.util.Arrays;

class MaxCompatibilitySum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        boolean[] visitedStu = new boolean[n];
        boolean[] visitedMen = new boolean[n];
        return f(students, mentors, visitedStu, visitedMen);
    }
    private int f(int[][] nums1, int[][] nums2, boolean[] vis1, boolean[] vis2) {
        if (allTrue(vis1)) return 0;

        int sel1 = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (!vis1[i]) {
                sel1 = i;
                break;
            }
        }

        boolean[] temp1 = Arrays.copyOfRange(vis1, 0, vis1.length);
        temp1[sel1] = true;
        int res = -1;
        for (int i = 0; i < nums2.length; i++) {
            if (!vis2[i]) {
                boolean[] temp2 = Arrays.copyOfRange(vis2, 0, vis2.length);
                temp2[i] = true;
                res = Math.max(res, count(nums1, nums2, sel1, i) + f(nums1, nums2, temp1, temp2));
            }
        }
        return res;
    }
    private int count(int[][] nums1, int[][] nums2, int i, int j) {
        int res = 0;
        for (int k = 0; k < nums1[i].length; k++) {
            if (nums1[i][k] == nums2[j][k]) {
                res++;
            }
        }
        return res;
    }
    private boolean allTrue(boolean[] vis) {
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }
}