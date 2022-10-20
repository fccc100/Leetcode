import java.util.HashMap;

class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        while (l < n && nums[l] % 2 == 0) {
            l++;
        }

        int r = l + 1;
        if (l >= n) return 0;
        int oddCnt = 1;
        while (r < n && oddCnt < k) {
            if (nums[r] % 2 != 0) {
                oddCnt++;
            }
            r++;
        }
        if (r >= n) return 0;
        r--;

        HashMap<Integer, Integer> leftOdd = new HashMap<>();
        int oddIdx = -1;
        for (int i = 0; i < n; i++) {
            leftOdd.put(i, oddIdx);
            if (nums[i] % 2 != 0) {
                oddIdx = i;
            }
        }

        HashMap<Integer, Integer> rightOdd = new HashMap<>();
        int rightOddIdx = n;
        for (int i = n - 1; i >= 0; i--) {
            rightOdd.put(i, rightOddIdx);
            if (nums[i] % 2 != 0) {
                rightOddIdx = i;
            }
        }

        int res = 0;
        res += (l - leftOdd.get(l)) * (rightOdd.get(r) - r);
        while (r < n) {
            int nr = r + 1;
            while (nr < n && nums[nr] % 2 == 0) {
                nr++;
            }
            if (nr >= n) break;
            r = nr;

            int nl = l + 1;
            while (nl < n && nums[nl] % 2 == 0) {
                nl++;
            }
            l = nl;
            res += (l - leftOdd.get(l)) * (rightOdd.get(r) - r);
        }
        return res;
    }
}