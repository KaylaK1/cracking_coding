package com.crackingcoding.recursion;

import java.math.BigInteger;

public class Fibonacci {
    // Brute force - O(2^n) or O(1.6^n)
    public static BigInteger computeExponential(int i) {
        if (i == 0 || i == 1)
            return BigInteger.valueOf(i);
        return computeExponential(i - 1)
                .add(computeExponential(i - 2));
    }

    // Top-down Dynamic Programming (Memoization)
    public static BigInteger computeTopDown(int n) {
        return computeTopDown(n, new BigInteger[n + 1]);
    }

    // If the computed value of n is not saved. Save it. If the computed value
    // exists in the memo, use it instead of recalculating
    public static BigInteger computeTopDown(int n, BigInteger[] memo) {
        if (n == 1 || n == 0)
            return BigInteger.valueOf(n);

        if (memo[n] == null) {
            return memo[n] = computeTopDown(n - 1, memo).add(computeTopDown(n - 2, memo));
        }
        return memo[n];
    }

    public static void main(String[] args) {
        BigInteger result = Fibonacci.computeTopDown(10);
        System.out.println(result);
    }
}
