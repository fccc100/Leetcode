/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function (names, heights) {
    let n = names.length;

    for (let i = 0; i < names.length; i++) {
        names[i] = [names[i], heights[i]];
    }

    names.sort((a, b) => b[1] - a[1]);

    for (let i = 0; i < n; i++) {
        names[i] = names[i][0];
    }
    return names;
};