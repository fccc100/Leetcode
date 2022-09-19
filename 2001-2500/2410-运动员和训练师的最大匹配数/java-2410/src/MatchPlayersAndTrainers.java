import java.util.Arrays;

class MatchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;

        int res = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
}