package tdd_calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class PrimitiveTests {
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

    @Test
    public void test_number(){
        expected = 15;
        actual = Calculator.calculate(Double.valueOf(15).toString());
        assertTrue(expected == actual);
    }

    @Test
    public void test_simpleAddition(){
        expected = 5;
        actual = Calculator.calculate("2+3");
        assertTrue(expected == actual);
    }
}
