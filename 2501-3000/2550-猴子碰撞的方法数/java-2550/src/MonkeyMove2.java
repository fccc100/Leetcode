import java.math.BigInteger;

public class MonkeyMove2 {
    public int monkeyMove(int n) {
        int MOD = 1000000007;
        int res = (BigInteger.TWO.modPow(BigInteger.valueOf(n), BigInteger.valueOf(MOD)).intValue() - 2 + MOD) % MOD;
        return res;
    }
}
