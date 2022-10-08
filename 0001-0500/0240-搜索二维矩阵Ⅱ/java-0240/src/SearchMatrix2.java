public class SearchMatrix2 {
    // 二分查找，O(nlogm)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        for (int i = 0; i < m; i++) {
            int l = 0;
            int r = n - 1;

            while (l <= r) {
                int mid = l + (r - l >> 1);
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
