class MinOperations {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long add = 0;
        long sub = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) continue;

            if (nums1[i] > nums2[i]) {
                int diff = nums1[i] - nums2[i];
                if (k == 0 || diff % k != 0) return -1;
                sub += diff / k;
            }
            if (nums1[i] < nums2[i]) {
                int diff = nums2[i] - nums1[i];
                if (k == 0 || diff % k != 0) return -1;
                add += diff / k;
            }
        }
        return add == sub ? add : -1;
    }
}