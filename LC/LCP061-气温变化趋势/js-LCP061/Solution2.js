/**
 * @param {number[]} temperatureA
 * @param {number[]} temperatureB
 * @return {number}
 */
var temperatureTrend = function (temperatureA, temperatureB) {
    let n = temperatureA.length;

    let ta = Array(n).fill(0);
    let tb = Array(n).fill(0);

    let res = 0;
    let cur = 0;
    for (let i = 1; i < n; i++) {
        if (temperatureA[i] - temperatureA[i - 1] > 0) {
            ta[i] = 1;
        } else if (temperatureA[i] - temperatureA[i - 1] == 0) {
            ta[i] = 0;
        } else {
            ta[i] = -1;
        }

        if (temperatureB[i] - temperatureB[i - 1] > 0) {
            tb[i] = 1;
        } else if (temperatureB[i] - temperatureB[i - 1] == 0) {
            tb[i] = 0;
        } else {
            tb[i] = -1;
        }

        if (ta[i] == tb[i]) {
            cur++;
        } else {
            cur = 0;
        }
        res = Math.max(res, cur);
    }

    return res;
};