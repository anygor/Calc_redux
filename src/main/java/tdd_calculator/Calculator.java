package tdd_calculator;


import com.sun.deploy.util.StringUtils;

public class Calculator {
    private static char exp_arr[];
    private static int plus[];
    private static int size;

    public static double calculate(String exp){
        if (exp.contains("+")){
            int plusAmount = exp.length() - exp.replaceAll("\\+", "").length();
            double[] addendum = new double[plusAmount + 1];
            addendum[0] = Double.parseDouble(exp.substring(0,exp.indexOf("+")));
            exp = exp.substring(exp.indexOf("+") + 1);
            addendum[1] = Double.parseDouble(exp.substring(0,exp.indexOf("+")));
            exp = exp.substring(exp.indexOf("+") + 1);
            addendum[2] = Double.parseDouble(exp);
            return addendum[0] + addendum[1] + addendum[2];
        }
        return Double.valueOf(exp);
    }

    private static double add(double[] addendum){
        double result = 0;
        for(int i = 0; i < addendum.length; i++){
            result += addendum[i];
        }
        return result;
    }

    public static void main( String[] args ) {
        String a = "2+3+1";
        double result = Calculator.calculate(a);
        System.out.println(result);
    }
}