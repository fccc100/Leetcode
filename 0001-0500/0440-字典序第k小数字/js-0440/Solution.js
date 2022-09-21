/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var findKthNumber = function (n, k) {
    let pre = 1;
    let cnt = 1;

    while (cnt < k) {
        let curCnt = getCount(pre, n);

        if (cnt + curCnt > k) {
            pre *= 10;
            cnt++;
        } else {
            cnt += curCnt;
            pre ++;
        }
    }
    return pre;
};

// 获取前缀p下拥有的n以内的节点个数
function getCount(p, n) {
    let cur = p;
    let next = cur + 1;

    let cnt = 0;
    while (cur <= n) {
        cnt += Math.min(n + 1, next) - cur;

        cur *= 10;
        next *= 10;
    }
    return cnt;
}
