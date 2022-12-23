class FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if (s.equals("X--") || s.equals("--X")) {
                res--;
            } else {
                res++;
            }
        }
        return res;
    }
}