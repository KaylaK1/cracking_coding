package com.crackingcoding.recursion;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameters(name = "{index}: fib({0})={1}")
    public static Collection<Object[]> data() {
        // return Arrays.asList(new Object[][] {
        // { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 },
        // { 30, 832040 }, { 100, 354224848179261915075 }
        // });
        return Arrays.asList(new Object[][] {
                { 1, BigInteger.valueOf(1) },
                { 5, BigInteger.valueOf(5) },
                { 10, BigInteger.valueOf(55) },
                { 20, BigInteger.valueOf(6765) },
                { 30, BigInteger.valueOf(832040) },
                { 40, BigInteger.valueOf(102334155) },
                { 41, BigInteger.valueOf(165580141) },
                { 43, BigInteger.valueOf(433494437) },
                { 44, BigInteger.valueOf(701408733) },
                { 45, BigInteger.valueOf(1134903170) },
                // { 100, new BigInteger("354224848179261915075") } //
                // declare since extremely
                // larger
        });
    }

    // can use @Parameter and public variables instead of constructor
    private int fInput;
    private BigInteger fExpected;

    public FibonacciTest(int input, BigInteger expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    @DisplayName("2^n Brute Force")
    public void testExponential() {
        assertEquals(fExpected, Fibonacci.computeExponential(fInput));
    }

    @Test
    @DisplayName("O(n) Top Down")
    public void testTopDown() {
        assertEquals(fExpected, Fibonacci.computeTopDown(fInput));
    }
}