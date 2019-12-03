package tdd_calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class AppTest {
    private double expected;
    private double actual;
    @BeforeClass
    public static void setUp() {
    }

    @Test
    public void test_zero() {
        expected = 0;
        actual = Calculator.calculate("0");
        assertTrue(expected == actual);
    }
}
