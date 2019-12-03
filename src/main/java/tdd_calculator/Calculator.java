package tdd_calculator;


import com.sun.deploy.util.StringUtils;

public class Calculator {
    private static char exp_arr[];
    private static int plus[];
    private static int size;

    public static double calculate(String exp){
        if (exp.contains("+")){
            return Calculator.add(exp);
        }
        return Double.valueOf(exp);
    }

    private static double add(String exp){
        double result = 0;
        int plusAmount = exp.length() - exp.replaceAll("\\+", "").length();
        double[] addendum = new double[plusAmount + 1];
        for (int i = 0; i < addendum.length; i++) {
            if (exp.contains("+")) {
                addendum[i] = Double.parseDouble(exp.substring(0, exp.indexOf("+")));
                result += addendum[i];
                exp = exp.substring(exp.indexOf("+") + 1);
            }
            else {
                addendum[i] = Double.parseDouble(exp);
                result += addendum[i];
            }
        }
        return result;
    }

    public static void main( String[] args ) {
        String a = "2+3+1+5";
        double result = Calculator.calculate(a);
        System.out.println(result);
    }
}