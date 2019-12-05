package tdd_calculator;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public static double calculate(String expression) {
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

        List<String> exp_list = new LinkedList<String>(Arrays.asList(exp_arr));

        // Searching for square root
        for(int i = 0; i < exp_list.size(); i++){
            if(exp_list.get(i).contains("sqrt")){
                exp_list.set(i, Double.toString(Math.sqrt(Double.parseDouble(exp_list.get(i).substring(4)))));
            }
        }

        int ind;
        // Searching for multiplication
        if (asterAmount != 0) {
            for (int i = 0; i < asterAmount; i++) {
                ind = exp_list.indexOf("*");
                exp_list.set(ind, Double.toString(Double.parseDouble(exp_list.get(ind - 1)) * Double.parseDouble(exp_list.get(ind + 1))));
                exp_list.remove(ind - 1);
                exp_list.remove(ind);
            }
        }

        // Searching for division
        if (slashAmount != 0) {
            for (int i = 0; i < slashAmount; i++) {
                ind = exp_list.indexOf("/");
                exp_list.set(ind, Double.toString(Double.parseDouble(exp_list.get(ind - 1)) / Double.parseDouble(exp_list.get(ind + 1))));
                exp_list.remove(ind - 1);
                exp_list.remove(ind);
            }
        }

        // Searching for addition
        if (plusAmount != 0) {
            for (int i = 0; i < plusAmount; i++) {
                ind = exp_list.indexOf("+");
                exp_list.set(ind, Double.toString(Double.parseDouble(exp_list.get(ind - 1)) + Double.parseDouble(exp_list.get(ind + 1))));
                exp_list.remove(ind - 1);
                exp_list.remove(ind);
            }
        }

        // Searching for subtraction
        if (minusAmount != 0) {
            for (int i = 0; i < minusAmount; i++) {
                ind = exp_list.indexOf("-");
                exp_list.set(ind, Double.toString(Double.parseDouble(exp_list.get(ind - 1)) - Double.parseDouble(exp_list.get(ind + 1))));
                exp_list.remove(ind - 1);
                exp_list.remove(ind);
            }
        }
        return Double.parseDouble(exp_list.get(0));
    }

    public static void main(String[] args) {
        String expression = "2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4";
        System.out.println(Calculator.calculate(expression));
    }
}