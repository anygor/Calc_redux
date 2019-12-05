package tdd_calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ComplexTests {
    private double expected;
    private double actual;

    @Test
    public void test_complexAddition(){
        expected = 16;
        actual = Calculator.calculate("10+3+2+1");
        assertEquals(expected, actual, 0.0);
    }
    @Test
    public void test_complexProduct(){
        expected = 60;
        actual = Calculator.calculate("10*3*2*1");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void test_complexSubstraction(){
        expected = 4;
        actual = Calculator.calculate("10-3-2-1");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void test_complexSubstractionThatBeginsWithMinus(){
        expected = -16;
        actual = Calculator.calculate("-10-3-2-1");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void test_complexDivision(){
        expected = 1;
        actual = Calculator.calculate("6/3/2");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void test_multiplyAndAdd(){
        expected = 2;
        actual = Calculator.calculate("17-3*5");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void test_actionOrder(){
        expected = 46;
        actual = Calculator.calculate("50-2*6+sqrt64");
        assertEquals(expected, actual, 0.0);

    }

    @Test
    public void test_AndrewIvanovTest(){
        expected = 12250.6;
        actual = Calculator.calculate("2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4");
        assertEquals(expected, actual, 1e-9);
    }
}
