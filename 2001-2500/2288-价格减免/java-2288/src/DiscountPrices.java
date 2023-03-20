class DiscountPrices {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.length() == 1) continue;
            if (w.charAt(0) == '$') {
                String num = w.substring(1);
                if (isDigit(num)) {
                    double v = Double.parseDouble(num);
                    v = v - (v * ((double)discount / 100));
                    String c = String.format("%.2f", v);
                    words[i] = "$" + c;
                }
            }
        }
        return String.join(" ", words);
    }
    private boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}