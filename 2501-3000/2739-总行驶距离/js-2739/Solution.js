/**
 * @param {number} mainTank
 * @param {number} additionalTank
 * @return {number}
 */
var distanceTraveled = function (mainTank, additionalTank) {
    let res = 0
    while (mainTank >= 5 && additionalTank > 0) {
        res += 5 * 10
        mainTank -= 5
        additionalTank -= 1
        mainTank += 1
    }
    res += mainTank * 10
    return res
};