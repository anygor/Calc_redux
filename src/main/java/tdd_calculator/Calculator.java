package tdd_calculator;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public static double calculate(String expression) {
        expression = expression.replaceAll(" ", "");

        int initial_length = expression.length();
        int plusAmount = initial_length - expression.replaceAll("\\+", "").length();
        int minusAmount = initial_length - expression.replaceAll("-", "").length();
        int asterAmount = initial_length - expression.replaceAll("\\*", "").length();
        int slashAmount = initial_length - expression.replaceAll("/", "").length();
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

        List<String> exp_list = new LinkedList<String>(Arrays.asList(exp_arr));

        // Searching for square root
        for(int i = 0; i < exp_list.size(); i++){
            if(exp_list.get(i).contains("sqrt")){
                exp_list.set(i, Double.toString(Math.sqrt(Double.parseDouble(exp_list.get(i).substring(4)))));
            }
        }

        // Searching for multiplication and/or division
        if (asterAmount != 0 || slashAmount != 0) {
            for (int i = 0; i < exp_list.size(); i++) {
                if(asterAmount != 0 && exp_list.get(i).equals("*")){
                    exp_list.set(i, Double.toString(Double.parseDouble(exp_list.get(i - 1)) * Double.parseDouble(exp_list.get(i + 1))));
                    exp_list.remove(i - 1);
                    exp_list.remove(i);
                    i--;
                }
                if(slashAmount != 0 && exp_list.get(i).equals("/")){
                    exp_list.set(i, Double.toString(Double.parseDouble(exp_list.get(i - 1)) / Double.parseDouble(exp_list.get(i + 1))));
                    exp_list.remove(i - 1);
                    exp_list.remove(i);
                    i--;
                }
            }
        }

        // Searching for addition and/or subtraction
        if (plusAmount != 0 || minusAmount != 0) {
            for (int i = 0; i < exp_list.size(); i++) {
                if(plusAmount != 0 && exp_list.get(i).equals("+")){
                    exp_list.set(i, Double.toString(Double.parseDouble(exp_list.get(i - 1)) + Double.parseDouble(exp_list.get(i + 1))));
                    exp_list.remove(i - 1);
                    exp_list.remove(i);
                    i--;
                }
                if(minusAmount != 0 && exp_list.get(i).equals("-")){
                    exp_list.set(i, Double.toString(Double.parseDouble(exp_list.get(i - 1)) - Double.parseDouble(exp_list.get(i + 1))));
                    exp_list.remove(i - 1);
                    exp_list.remove(i);
                    i--;
                }
            }
        }

        return Double.parseDouble(exp_list.get(0));
    }

    public static void main(String[] args) {
    }
}