class MinNumber {
    public int minNumber(int[] nums1, int[] nums2) {
        int res = 1;
        while (true) {
            String s = String.valueOf(res);
            boolean flag1 = false;
            boolean flag2 = false;

            for (int i = 0; i < s.length(); i++) {
                if (contains(nums1, s.charAt(i) - '0')) {
                    flag1 = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (contains(nums2, s.charAt(i) - '0')) {
                    flag2 = true;
                }
            }

            if (flag1 && flag2) return res;
            res++;
        }
    }
    private boolean contains(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return true;
        }
        return false;
    }
}