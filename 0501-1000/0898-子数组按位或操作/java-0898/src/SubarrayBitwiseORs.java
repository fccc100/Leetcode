import java.util.HashSet;

class SubarrayBitwiseORs {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;

        HashSet<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet();
        }

        HashSet<Integer> res = new HashSet<>();
        dp[0].add(arr[0]);
        res.add(arr[0]);

        for (int i = 1; i < n; i++) {
            HashSet<Integer> preSet = dp[i - 1];

            for (Integer k: preSet) {
                dp[i].add(k | arr[i]);
                res.add(k | arr[i]);
            }
            dp[i].add(arr[i]);
            res.add(arr[i]);
        }
        return res.size();
    }
}