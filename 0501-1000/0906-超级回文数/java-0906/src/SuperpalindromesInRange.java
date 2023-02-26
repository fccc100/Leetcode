import sun.rmi.runtime.Log;

class SuperpalindromesInRange {
    public int superpalindromesInRange(String left, String right) {
        int res = 0;
        for (int i = 1; i <= 100000; i++) {
            String o = String.valueOf(i);
            StringBuilder t1 = new StringBuilder();
            t1.append(o);
            for (int j = o.length() - 1; j >= 0; j--) {
                t1.append(o.charAt(j));
            }
            long m1 = Long.valueOf(t1.toString()) * Long.valueOf(t1.toString());
            if (m1 >= Long.valueOf(left) && m1 <= Long.valueOf(right) && isValid(m1)) {
                res++;
            }
            StringBuilder t2 = new StringBuilder();
            t2.append(o);
            for (int j = o.length() - 2; j >= 0; j--) {
                t2.append(o.charAt(j));
            }

            long m2 = Long.valueOf(t2.toString()) * Long.valueOf(t2.toString());
            if (m2 > Long.valueOf(right)) break;
            if (m2 >= Long.valueOf(left) && isValid(m2)) {
                res++;
            }
        }
        return res;
    }
    private boolean isValid(long n) {
        String s = String.valueOf(n);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}