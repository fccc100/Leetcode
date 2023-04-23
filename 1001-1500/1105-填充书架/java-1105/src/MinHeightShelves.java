import java.util.Arrays;

class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; j--) {
                curWidth += books[j][0];
                if (curWidth <= shelfWidth) {
                    maxHeight = Math.max(maxHeight, books[j][1]);
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
                } else break;
            }
        }
        return dp[n];
    }
}
