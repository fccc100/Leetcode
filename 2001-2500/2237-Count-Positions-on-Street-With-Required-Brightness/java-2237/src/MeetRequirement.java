class MeetRequirement {
    // 差分
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] diff = new int[n + 1];

        for (int i = 0; i < lights.length; i++) {
            diff[Math.max(0, lights[i][0] - lights[i][1])]++;
            diff[Math.min(n - 1, lights[i][0] + lights[i][1]) + 1]--;
        }

        int res = 0;
        if (diff[0] >= requirement[0]) {
            res++;
        }

        for (int i = 1; i < n; i++) {
            diff[i] = diff[i - 1] + diff[i];
            if (diff[i] >= requirement[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] a = {{0, 1}, {2, 1}, {3, 2}};
        int[] b = {0, 2, 1, 4, 1};
        System.out.print(new MeetRequirement().meetRequirement(5, a, b));
    }
}