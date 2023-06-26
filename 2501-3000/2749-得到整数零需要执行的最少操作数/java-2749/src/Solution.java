class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 0; k <= num1 - num2 * k; k++) {
            if (k >= Long.bitCount(num1 - num2 * k)) {
                return (int) k;
            }
        }
        return -1;
    }
}