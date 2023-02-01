class IsReachable {
    public boolean isReachable(int targetX, int targetY) {
        while (targetX % 2 == 0) {
            targetX /= 2;
        }
        while (targetY % 2 == 0) {
            targetY /= 2;
        }
        return gcd(targetX, targetY) == 1;
    }
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}