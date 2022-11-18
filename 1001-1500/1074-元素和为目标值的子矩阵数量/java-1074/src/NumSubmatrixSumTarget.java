import java.util.HashMap;

class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;

        HashMap<String, Boolean> map = new HashMap<>();
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                presum[i][j] = presum[i - 1][j] + matrix[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {

                int[] curNums = new int[n];
                for (int k = 0; k < n; k++) {
                    curNums[k] = presum[j + 1][k + 1] - presum[i][k + 1];
                }

                res += subarraySum(curNums, target);
            }
        }

        return res;
    }
    private int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (presum[i] == k) {
                res++;
            }
            if (map.containsKey(presum[i] - k)) {
                res += map.get(presum[i] - k);
            }
            map.put(presum[i], map.getOrDefault(presum[i], 0) + 1);
        }
        return res;
    }
}
