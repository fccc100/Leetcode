import java.util.HashMap;

class FixedRatio {
    public long fixedRatio(String s, int num1, int num2) {
        int n = s.length();
        int zero = 0;
        int one = 0;
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }

            if (zero * num2 == one * num1) {
                res++;
            }

            int k = zero * num2 - one * num1;
            if (map.containsKey(k)) {
                res += map.get(k);
            }

            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        return res;
    }
}

// 推导：
//       0 1 1 0 0 1 1
// zero [1,1,1,2,3,3,3]
// one  [0,1,2,2,2,3,4]
//       x x
// zero[j] - zero[i] : one[j] - one[i] = nums1 : nums2
// (zero[j] - zero[i]) * nums2 = (one[j] - one[i]) * nums1
// zero[j] * nums2 - zero[i] * nums2 = one[j] * nums1 - one[i] * nums1

// zero[j] * nums2 - one[j] * nums1 = zero[i] * nums2 - one[i] * nums1

