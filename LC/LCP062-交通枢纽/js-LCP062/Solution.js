/**
 * @param {number[][]} path
 * @return {number}
 */
var transportationHub = function(path) {
    let n = 0;
    for (let i = 0; i < path.length; i++) {
        n = Math.max(n, path[i][0], path[i][1]);
    }
    n++;

    let inDegree = Array(n).fill(0);
    let outDegree = Array(n).fill(0);

    for (let i = 0; i < path.length; i++) {
        inDegree[path[i][1]]++;
        outDegree[path[i][0]]++;
    }

    for (let i = 0; i < inDegree.length; i++) {
        if (outDegree[i] == 0 && inDegree[i] == n - 1) {
            return i;
        }
    }
    return -1;
};