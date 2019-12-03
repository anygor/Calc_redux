package tdd_calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ComplexTests {
    private double expected;
    private double actual;

    @Test
    public void test_simpleAddition(){
        expected = 6;
        actual = Calculator.calculate("2+3+1");
        assertTrue(expected == actual);
    }
}
