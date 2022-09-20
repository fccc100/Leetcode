var rangeBitwiseAnd = function(left, right) {
    let cnt = 0;
    while (left < right) {
        left = left >> 1;
        right = right >> 1;
        cnt++;
    }
    return left << cnt;
}