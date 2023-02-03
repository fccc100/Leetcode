class Solution:
    def monkeyMove(self, n: int) -> int:
        MOD = 1000000007
        return (pow(2, n, MOD) - 2 + MOD) % MOD