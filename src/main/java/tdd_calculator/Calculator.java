package tdd_calculator;


public class Calculator {
    private static char exp_arr[];
    private static int plus[];
    private static int size;

    public static double calculate(String exp){
        if (exp.contains("+")){
            return Calculator.add(exp);
        }
        if(exp.contains("*")){
            return Calculator.multi(exp);
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

    private static double multi(String exp){
        double result = 1;
        int asterAmount = exp.length() - exp.replaceAll("\\*", "").length();
        double[] multiplier = new double[asterAmount + 1];
        for (int i = 0; i < multiplier.length; i++) {
            if (exp.contains("*")) {
                multiplier[i] = Double.parseDouble(exp.substring(0, exp.indexOf("*")));
                result *= multiplier[i];
                exp = exp.substring(exp.indexOf("*") + 1);
            }
            else {
                multiplier[i] = Double.parseDouble(exp);
                result *= multiplier[i];
            }
        }
        return result;
    }



    public static void main( String[] args ) {
        String a = "2*3";
        double result = Calculator.calculate(a);
        System.out.println(result);
    }
}