/**
 * @param {number[]} players
 * @param {number[]} trainers
 * @return {number}
 */
var matchPlayersAndTrainers = function (players, trainers) {
    players.sort((a, b) => a - b);
    trainers.sort((a, b) => a - b);

    let res = 0;
    let i = 0;
    let j = 0;

    while (i < players.length && j < trainers.length) {
        if (players[i] <= trainers[j]) {
            res++;
            i++;
            j++;
        } else {
            j++;
        }
    }
    return res;
};