class AreNumbersAscending {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            boolean isDigit = true;
            for (int j = 0; j < str.length(); j++) {
                if (!Character.isDigit(str.charAt(j))) {
                    isDigit = false;
                    break;
                }
            }

            if (isDigit) {
                int val = Integer.valueOf(str);
                if (val <= cur) {
                    return false;
                }
                cur = val;
            }
        }
        return true;
    }
}