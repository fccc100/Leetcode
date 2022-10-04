public class MinAddToMakeValid2 {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        int res = 0;
        int leftCnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                leftCnt++;
            } else {
                if (leftCnt > 0) {
                    leftCnt--;
                } else {
                    res++;
                }
            }
        }
        return res + leftCnt;
    }
}
