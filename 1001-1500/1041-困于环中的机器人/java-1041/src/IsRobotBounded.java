class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                int c = instructions.charAt(j);

                if (c == 'L') {
                    d = (d - 1 + 4) % 4;
                } else if (c == 'R') {
                    d = (d + 1) % 4;
                } else {
                    if (d == 0) {
                        y++;
                    } else if (d == 1) {
                        x++;
                    } else if (d == 2) {
                        y--;
                    } else if (d == 3) {
                        x--;
                    }
                }
            }
        }
        return x == 0 && y == 0;
    }
}