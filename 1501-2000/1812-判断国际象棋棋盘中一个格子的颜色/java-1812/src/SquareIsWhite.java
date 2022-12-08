class SquareIsWhite {
    public boolean squareIsWhite(String coordinates) {
        char c1 = coordinates.charAt(0);
        int c2 = coordinates.charAt(1) - '0';
        if (c1 == 'a' || c1 == 'c' || c1 == 'e' || c1 == 'g') {
            return c2 % 2 == 0;
        } else {
            return c2 % 2 == 1;
        }
    }
}