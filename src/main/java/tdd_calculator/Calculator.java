package tdd_calculator;


public class Calculator {

    public static double calculate(String exp){
        exp = exp.replaceAll(" ", "");
        if(exp.contains("sqrt")){
            return sqrt(exp);
        }
        if(exp.contains("*")){
            return Calculator.multi(exp);
        }
        if(exp.contains("/")){
            return Calculator.div(exp);
        }
        if (exp.contains("+")){
            return Calculator.add(exp);
        }
        if(exp.contains("-")){
            return Calculator.sub(exp);
        }
        return Double.parseDouble(exp);
    }

    private static double add(String exp){
        double result = 0;
        int plusAmount = exp.length() - exp.replaceAll("\\+", "").length();
        for (int i = 0; i < plusAmount + 1; i++) {
            if (exp.contains("+")) {
                result += Double.parseDouble(exp.substring(0, exp.indexOf("+")));
                exp = exp.substring(exp.indexOf("+") + 1);
            }
            else {
                result += Double.parseDouble(exp);
            }
        }
        return result;
    }

    private static double multi(String exp){
        double result = 1;
        int asterAmount = exp.length() - exp.replaceAll("\\*", "").length();
        for (int i = 0; i < asterAmount + 1; i++) {
            if (exp.contains("*")) {
                result *= Double.parseDouble(exp.substring(0, exp.indexOf("*")));
                exp = exp.substring(exp.indexOf("*") + 1);
            }
            else {
                result *= Double.parseDouble(exp);
            }
        }
        return result;
    }

    private static double sub(String exp){
        double result = 0;
        int minusAmount = exp.length() - exp.replaceAll("\\-", "").length();
        if (exp.indexOf("-") != 0) {
            minusAmount += 1;
        }
        for (int i = 0; i < minusAmount; i++) {
            if (exp.contains("-")) {
                if (exp.indexOf("-") == 0){
                    exp = exp.substring(1);
                    if(exp.contains("-")){
                        result -= Double.parseDouble(exp.substring(0, exp.indexOf("-")));
                        exp = exp.substring(exp.indexOf("-"));
                    }
                    else{
                        result -= Double.parseDouble(exp);
                    }

                }
                else{
                    result += Double.parseDouble(exp.substring(0, exp.indexOf("-")));
                    exp = exp.substring(exp.indexOf("-"));
                }
            }
            else {
                result += Double.parseDouble(exp);
            }
        }
        return result;
    }

    private static double div(String exp){
        double result = Double.parseDouble(exp.substring(0, exp.indexOf("/")));
        exp = exp.substring(exp.indexOf("/") + 1);
        int slashAmount = exp.length() - exp.replaceAll("\\/", "").length();
        for (int i = 0; i < slashAmount + 1; i++) {
            if (exp.contains("/")) {
                result /= Double.parseDouble(exp.substring(0, exp.indexOf("/")));
                exp = exp.substring(exp.indexOf("/") + 1);
            } else {
                result /= Double.parseDouble(exp);
            }
        }
        return result;
    }

    private static double sqrt(String exp){
        exp = exp.substring(exp.indexOf("sqrt") + 4);
        return Math.sqrt(Double.parseDouble(exp));
    }

    private static String sort(String exp){
        int indexBefore;
        return exp;
    }


    public static void main( String[] args ) {
        String expression = "-10.5-2-3-1";
        double result = Calculator.calculate(expression);
        System.out.println(result);
    }
}