class MinLength {
    public int minLength(String s) {
        if (s.indexOf("AB") < 0 && s.indexOf("CD") < 0) {
            return s.length();
        }

        s = s.replaceAll("AB", "");
        s = s.replaceAll("CD", "");
        return minLength(s);
    }
}