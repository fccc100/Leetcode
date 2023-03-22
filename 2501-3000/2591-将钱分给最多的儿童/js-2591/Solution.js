/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 */
var distMoney = function (money, children) {
    if (money < children) return -1

    money -= children

    let res = 0
    for (let i = 1; i <= children; i++) {
        if (money >= 7) {
            money -= 7
            res++
        }
    }
    if (res == children && money > 0) return res - 1
    if (res == children - 1 && money == 3) return res - 1
    return res
};