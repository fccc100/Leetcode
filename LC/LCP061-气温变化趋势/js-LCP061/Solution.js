/**
 * @param {number[]} temperatureA
 * @param {number[]} temperatureB
 * @return {number}
 */
var temperatureTrend = function (temperatureA, temperatureB) {
    let n = temperatureA.length;

    let res = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            let a = temperatureA[j] - temperatureA[j - 1];
            let b = temperatureB[j] - temperatureB[j - 1]
            if ((a == 0 && b != 0) || (a != 0 && b == 0) || (a > 0 && b < 0) || (a < 0 && b > 0)) {
                break;
            }

            res = Math.max(res, j - i);
        }
    }
    return res;
};