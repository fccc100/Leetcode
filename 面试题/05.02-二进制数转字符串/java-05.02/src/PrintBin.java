class PrintBin {
    public String printBin(double num) {
        StringBuilder res = new StringBuilder("0.");
        while (res.length() <= 32 && num != 0) {
            num *= 2;
            double d = Math.floor(num);
            res.append((int) d);
            num -= d;
        }
        return res.length() <= 32 ? res.toString() : "ERROR";
    }
}