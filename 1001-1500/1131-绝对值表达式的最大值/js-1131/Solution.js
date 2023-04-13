/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number}
 */
var maxAbsValExpr = function (arr1, arr2) {
    let n = arr1.length

    let max1 = -Infinity, min1 = Infinity
    let max2 = -Infinity, min2 = Infinity
    let max3 = -Infinity, max33 = -Infinity
    let max4 = -Infinity, max44 = -Infinity
    let max5 = -Infinity, max55 = -Infinity
    let max6 = -Infinity, max66 = -Infinity
    let max7 = -Infinity, max77 = -Infinity
    let max8 = -Infinity, max88 = -Infinity

    for (let i = 0; i < n; i++) {
        let x1 = arr1[i], x2 = arr2[i]

        max1 = Math.max(max1, x1 + x2 + i)
        min1 = Math.min(min1, x1 + x2 + i)

        max2 = Math.max(max2, x1 + x2 - i)
        min2 = Math.min(min2, x1 + x2 - i)

        max3 = Math.max(max3, x1 - x2 + i)
        max33 = Math.max(max33, x2 - x1 - i)

        max4 = Math.max(max4, x1 - x2 - i)
        max44 = Math.max(max44, x2 - x1 + i)

        max5 = Math.max(max5, -x1 + x2 + i)
        max55 = Math.max(max55, x1 - x2 - i)

        max6 = Math.max(max6, -x1 + x2 - i)
        max66 = Math.max(max66, x1 - x2 + i)

        max7 = Math.max(max7, -x1 - x2 + i)
        max77 = Math.max(max77, x1 + x2 - i)

        max8 = Math.max(max8, -x1 - x2 - i)
        max88 = Math.max(max88, x1 + x2 + i)
    }

    return Math.max(max1 - min1, max2 - min2, max3 + max33, max4 + max44, max5 + max55, max6 + max66, max7 + max77, max8 + max88)
}
