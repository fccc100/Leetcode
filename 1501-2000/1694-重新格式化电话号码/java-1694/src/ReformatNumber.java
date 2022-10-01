class ReformatNumber {
    public String reformatNumber(String number) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '-' || number.charAt(i) == ' ') {
                continue;
            }
            num.append(number.charAt(i));
        }

        int mod = num.length() % 3;
        StringBuilder res = new StringBuilder();
        if (mod == 1) {
            for (int i = 0; i < num.length() - 4; i += 3) {
                res.append(num.substring(i, i + 3));
                res.append('-');
            }
            for (int i = num.length() - 4; i < num.length(); i += 2) {
                res.append(num.substring(i, i + 2));
                if (i + 2 < num.length()) {
                    res.append('-');
                }
            }
            return  res.toString();
        } else {
            for (int i = 0; i < num.length(); i += 3) {
                res.append(num.substring(i, i + 3));
                if (i + 3 < num.length()) {
                    res.append('-');
                }
            }
            return res.toString();
        }
    }
}