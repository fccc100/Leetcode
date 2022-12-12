class MaxJump {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int res = stones[1] - stones[0];
        for (int i = 2; i < n; i++) {
            res = Math.max(res, stones[i] - stones[i - 2]);
        }
        return res;
    }
}