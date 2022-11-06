class Interpret {
    public String interpret(String command) {
        int n = command.length();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ) {
            if (command.charAt(i) == 'G') {
                res.append('G');
                i++;
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append('o');
                    i += 2;
                } else {
                    res.append("al");
                    i += 4;
                }
            }
        }
        return res.toString();
    }
}