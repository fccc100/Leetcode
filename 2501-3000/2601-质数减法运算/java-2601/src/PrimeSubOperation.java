import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

class PrimeSubOperation {
    public boolean primeSubOperation(int[] nums) {
        int[] isPrime = getPrimes(1001);

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == 1) primes.add(i);
        }

        int p0 = -1;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) >= nums[0]) {
                break;
            }
            p0 = primes.get(i);
        }
        if (p0 > -1) nums[0] -= p0;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            int p = -1;
            for (int j = 0; j < primes.size(); j++) {
                if (cur - primes.get(j) > nums[i - 1]) {
                    p = primes.get(j);
                } else {
                    break;
                }
            }

            if (p == -1 && nums[i] <= nums[i - 1]) return false;
            if (p > -1) {
                nums[i] -= p;
            }
        }

        return true;
    }
    private int[] getPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 0; i < 2; i++) isPrime[i] = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return isPrime;
    }
}