import java.util.Arrays;

class CountRoutes {
    int MOD;
    int[][] memo;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        MOD = 1000000007;
        memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }
    private int dfs(int[] location, int start, int finish, int fuel) {
        int n = location.length;
        if (fuel < 0) return 0;

        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }

        int res = 0;
        if (start == finish) res += 1;

        for (int i = 0; i < n; i++) {
            if (i != start) {
                if (Math.abs(location[i] - location[start]) <= fuel) {
                    res += dfs(location, i, finish, fuel - Math.abs(location[i] - location[start]));
                    res %= MOD;
                }
            }
        }
        return memo[start][fuel] = res;
    }
}