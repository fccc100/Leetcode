class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            String s1 = String.valueOf(nums[i]);
            for (int j = i + 1; j < n; j++) {
                String s2 = String.valueOf(nums[j]);

                if (gcd(s1.charAt(0) - '0', s2.charAt(s2.length() - 1) - '0') == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;

        return gcd(y, x % y);
    }
}