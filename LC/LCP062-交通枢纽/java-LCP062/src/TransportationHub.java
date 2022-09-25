class TransportationHub {
    public int transportationHub(int[][] path) {
        int n = 0;
        for (int i = 0; i < path.length; i++) {
            n = Math.max(n, Math.max(path[i][0], path[i][1]));
        }
        n = n + 1;

        int [] inDegree = new int[n];
        int [] outDegree = new int[n];
        for (int i = 0; i < path.length; i++) {
            inDegree[path[i][1]]++;
            outDegree[path[i][0]]++;
        }

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}