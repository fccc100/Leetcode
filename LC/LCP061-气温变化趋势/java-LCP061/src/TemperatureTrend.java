class TemperatureTrend {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = temperatureA[j] - temperatureA[j - 1];
                int b = temperatureB[j] - temperatureB[j - 1];

                if ((a == 0 && b != 0) || (a != 0 && b == 0) || (a > 0 && b < 0) || (a < 0 && b > 0)) {
                    break;
                }

                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}