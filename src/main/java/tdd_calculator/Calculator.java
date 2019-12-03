package tdd_calculator;


public class Calculator {
    private static char exp_arr[];
    private static int plus[];
    private static int size;

    public static double calculate(String exp){
        if(exp.contains("+")){
            String a = exp.substring(0, exp.indexOf("+"));
            String b = exp.substring(exp.indexOf("+"));
            return Double.valueOf(a)+Double.valueOf(b);
        }
        return Double.valueOf(exp);
    }

    public static void main( String[] args ) {
        double result = Calculator.calculate("2+3");
        System.out.println(result);
    }
}