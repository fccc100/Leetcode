
class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if (n == 0) return cells;
        cells = nextCells(cells);

        n %= 14;
        if (n == 0) n = 14;

        for (int i = 1; i < n; i++) {
            cells = nextCells(cells);
        }
        return cells;
    }

    private int[] nextCells(int[] cells) {
        int[] res = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if ((cells[i - 1] == 0 && cells[i + 1] == 0) || (cells[i - 1] == 1 && cells[i + 1] == 1)) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
