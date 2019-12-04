package tdd_calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PrimitiveTests {
    private double expected;
    private double actual;

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

    @Test
    public void test_simpleProduct(){
        expected = 6;
        actual = Calculator.calculate("2*3");
        assertTrue(expected == actual);
    }

    @Test
    public void test_simpleSubstract(){
        expected = 7;
        actual = Calculator.calculate("10-3");
        assertTrue(expected == actual);
    }

    @Test
    public void test_simpleDivision(){
        expected = 3.5;
        actual = Calculator.calculate("7/2");
        assertTrue(expected == actual);
    }

    @Test
    public void test_simpleSquareRoot(){
        expected = 2;
        actual = Calculator.calculate("sqrt4");
        assertTrue(expected == actual);
    }
}
