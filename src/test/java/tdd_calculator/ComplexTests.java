package tdd_calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


public class ComplexTests {
    private double expected;
    private double actual;

    @Test
    public void test_complexAddition(){
        expected = 16;
        actual = Calculator.calculate("10+3+2+1");
        assertTrue(expected == actual);
    }
    @Test
    public void test_complexProduct(){
        expected = 60;
        actual = Calculator.calculate("10*3*2*1");
        assertTrue(expected == actual);
    }

    @Test
    public void test_complexSubstraction(){
        expected = 4;
        actual = Calculator.calculate("10-3-2-1");
        assertTrue(expected == actual);
    }

}
