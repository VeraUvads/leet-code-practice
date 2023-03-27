package medium;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubtractionOperation_2601 {
    // https://leetcode.com/problems/prime-subtraction-operation/description/

    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = getPrimes(1000);
        for (int i = nums.length - 2; i >= 0; i--) {
            int prev = nums[i + 1];
            int cur = nums[i];
            if (prev > cur) continue;
            int leftMostPrime = binarySearch(primes, i, cur, prev);
            System.out.println(leftMostPrime);
            nums[i] = nums[i] - leftMostPrime;
            if (nums[i] < 1 || nums[i] >=  prev) return false;
        }
        return true;
    }

    private List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    private int binarySearch(List<Integer> primes, int i, int cur, int prev) {
        int start = 0;
        int end = primes.size() - 1;
        int leftMostPrime = primes.get(end);
        while (start < end) {
            int mid = (start + end) / 2;
            int prime = primes.get(mid);
            int operation = cur - prime;
            if (operation < prev) {
                leftMostPrime = Math.min(leftMostPrime, prime);
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return leftMostPrime;
    }
}
