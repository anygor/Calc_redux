package tdd_calculator;


public class Calculator {

    public static double calculate(String exp){
        if (exp.contains("+")){
            return Calculator.add(exp);
        }
        if(exp.contains("*")){
            return Calculator.multi(exp);
        }
        if(exp.contains("-")){
            return Calculator.sub(exp);
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

    private static double sub(String exp){
        double result = 0;
        int minusAmount = exp.length() - exp.replaceAll("\\-", "").length();
        double[] subtrahend = new double[minusAmount + 1];
        for (int i = 0; i < subtrahend.length; i++) {
            if (exp.contains("-")) {
                if (exp.indexOf("-") == 0){
                    exp = exp.substring(1);
                    if(exp.contains("-")){
                        subtrahend[i] = Double.parseDouble(exp.substring(0, exp.indexOf("-")));
                        result -= subtrahend[i];
                        exp = exp.substring(exp.indexOf("-"));
                    }
                    else{
                        subtrahend[i] = Double.parseDouble(exp);
                        result -= subtrahend[i];
                    }

                }
                else{
                    subtrahend[i] = Double.parseDouble(exp.substring(0, exp.indexOf("-")));
                    result += subtrahend[i];
                    exp = exp.substring(exp.indexOf("-"));
                }
            }
            else {
                subtrahend[i] = Double.parseDouble(exp);
                result += subtrahend[i];
            }
        }
        return result;
    }

    public static void main( String[] args ) {
        String a = "10-3";
        double result = Calculator.calculate(a);
        System.out.println(result);
        System.out.println(a.indexOf("-"));
    }
}