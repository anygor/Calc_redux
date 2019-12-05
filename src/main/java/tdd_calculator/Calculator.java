package tdd_calculator;


import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static double calculate(String exp) {
        return Double.parseDouble(exp);
    }

    public static void main(String[] args) {
        String expression = "-22*3-45.3*90+20-sqrt4-8/20";
        expression = expression.replaceAll(" ", "");
        int plusAmount = expression.length() - expression.replaceAll("\\+", "").length();
        int minusAmount = expression.length() - expression.replaceAll("-", "").length();
        int asterAmount = expression.length() - expression.replaceAll("\\*", "").length();
        int slashAmount = expression.length() - expression.replaceAll("/", "").length();
        int totalAmount = plusAmount + minusAmount + asterAmount + slashAmount;

        String[] exp_arr = new String[totalAmount * 2 + 1];

        int startPoint = 0;
        int expchar_counter = 0;


        for (int i = 0; i < expression.length(); i++) {
            if ((expression.contains("+") || expression.contains("-") || expression.contains("*") || expression.contains("/"))) {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                    exp_arr[expchar_counter] = expression.substring(0, i);
                    exp_arr[expchar_counter + 1] = Character.toString(expression.charAt(i));
                    expchar_counter += 2;
                    startPoint = i + 1;
                    expression = expression.substring(startPoint);
                    i = -1;
                }
            } else {
                exp_arr[expchar_counter] = expression;
                break;
            }
        }
        if(exp_arr[0].isEmpty())exp_arr[0] = "0";

        // Ищем умножение TODO
        List<String> exp_list = Arrays.asList(exp_arr);
        System.out.println(exp_list.toString());
        System.out.println(exp_list.toString());
    }
}