package jp.co.ncsx.example.training;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by hideyuki.sasakura on 1/25/2017 AD.
 */

public class FibonacciNumberTest {

    @Test
    public void calc() {
        FibonacciNumber fib = new FibonacciNumber();
        assertEquals(new Integer(0), fib.calc(String.valueOf(0)));
        assertEquals(new Integer(1), fib.calc(String.valueOf(1)));
        assertEquals(new Integer(1), fib.calc(String.valueOf(2)));
        assertEquals(new Integer(2), fib.calc(String.valueOf(3)));
        assertEquals(new Integer(3), fib.calc(String.valueOf(4)));
        assertEquals(new Integer(5), fib.calc(String.valueOf(5)));
        assertEquals(new Integer(8), fib.calc(String.valueOf(6)));
        assertEquals(new Integer(55), fib.calc(String.valueOf(10)));
    }

    public class FibonacciNumber {

        public Integer calc(String input) {
            Integer n = Integer.valueOf(input);
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return calc(String.valueOf(n - 1)) + calc(String.valueOf(n - 2));
            }
        }

    }
}
