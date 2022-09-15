/**
 * @param {number[]} arr
 * @return {number}
 */
var missingNumber = function(arr) {
    let n = arr.length;
    let sum = ((arr[0] + arr[n - 1]) * (n + 1)) / 2;

    for (let i = 0; i < arr.length; i++) {
        sum -= arr[i];
    }
    return sum;
};