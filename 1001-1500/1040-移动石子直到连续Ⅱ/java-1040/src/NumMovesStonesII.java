import java.util.Arrays;

class NumMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int maxMoves = Math.max(stones[n - 1] - stones[1] - (n - 2), stones[n - 2] - stones[0] - (n - 2));

        int minMoves = n;
        for (int i = 0, j = 0; i < n; i++) {
            while (stones[i] - stones[j] >= n) j++;
            if (i - j + 1 == n - 1 && stones[i] - stones[j] == n - 2) {
                minMoves = Math.min(minMoves, 2);
            }
            else {
                minMoves = Math.min(minMoves, n - (i - j + 1));
            }
        }
        return new int[] {minMoves, maxMoves};
    }
}