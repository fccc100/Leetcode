/**
 * @param {string} arriveAlice
 * @param {string} leaveAlice
 * @param {string} arriveBob
 * @param {string} leaveBob
 * @return {number}
 */
var countDaysTogether = function (arriveAlice, leaveAlice, arriveBob, leaveBob) {
    let days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if (arriveAlice > leaveBob || arriveBob > leaveAlice) return 0;

    if (arriveAlice == leaveBob || arriveBob == leaveAlice) return 1;

    let maxArrive = arriveAlice > arriveBob ? arriveAlice : arriveBob;
    let minLeave = leaveAlice < leaveBob ? leaveAlice : leaveBob;

    let m1 = maxArrive.split('-')[0] * 1;
    let d1 = maxArrive.split('-')[1] * 1;

    let m2 = minLeave.split('-')[0] * 1;
    let d2 = minLeave.split('-')[1] * 1;
    console.log(m1, d1, m2, d2)

    if (m1 == m2) {
        return d2 - d1 + 1;
    }

    let res = 0;
    res += (days[m1 - 1] - d1 + 1) * 1;
    for (let i = m1 + 1; i < m2; i++) {
        res += days[i - 1];
    }
    res += d2;
    return res;
};