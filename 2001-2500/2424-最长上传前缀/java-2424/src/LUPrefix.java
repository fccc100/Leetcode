class LUPrefix {

    int[] nums;
    int cur;
    public LUPrefix(int n) {
        nums = new int[n + 1];
        cur = 0;
    }

    public void upload(int video) {
        nums[video] = 1;
        while (cur + 1 < nums.length && nums[cur + 1] == 1) {
            cur++;
        }
    }

    public int longest() {
        return cur;
    }
}
