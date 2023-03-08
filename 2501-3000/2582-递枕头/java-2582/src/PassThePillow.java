class PassThePillow {
    public int passThePillow(int n, int time) {
        int m = time % (n - 1);
        return time / (n - 1) % 2 == 1 ? n - m : 1 + m;
    }
}
