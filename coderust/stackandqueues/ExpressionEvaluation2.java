package stackandqueues;

import common.Pair;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Given an arithmetic expression, evaluate it.
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 */
public class ExpressionEvaluation2 {

    public static void main(String[] args) {
        String expression = "3+6*5-1/2.5";
        System.out.println(evaluate(expression));
    }

    private static boolean isOperator(char temp) {
        return temp == '+' || temp == '-' || temp == '*' || temp == '/';
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isDivOrMul(char ch) {
        return ch == '*' || ch == '/';
    }

    private static Pair<Double, Integer> strToDouble(String s, int i) {
        int len = s.length();
        if (i >= len) {
            return null;
        }

        StringBuilder temp = new StringBuilder();
        while (i < len && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            ++i;
        }
        if (i >= len) {
            return null;
        }
        if (s.charAt(i) == '-') {
            temp.append('-');
            ++i;
        }
        for (; i < len; ++i) {
            char ch = s.charAt(i);
            if (ch != '.' && !isDigit(ch)) {
                break;
            }
            temp.append(ch);
        }
        return new Pair<>(Double.parseDouble(temp.toString()), i);
    }

    private static double evaluate(String expr) {
        java.util.LinkedList<Character> operators = new LinkedList<>();
        java.util.LinkedList<Double> operands = new LinkedList<>();

        char op = 0;
        double prev = 0;

        int i = 0;
        int len = expr.length();

        while (i < len) {
            char ch = expr.charAt(i);
            if (ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }
            if (isOperator(ch)) {
                op = ch;
                operators.add(ch);
                ++i;
            } else {
                Pair<Double, Integer> p = strToDouble(expr, i);
                double d = p.first;
                i = p.second;

                if (isDivOrMul(op)) {
                    operators.removeLast();
                    operands.removeLast();

                    prev = (op == '*') ? (prev * d) : (prev / d);
                    operands.add(prev);
                    op = 0;
                } else {
                    operands.add(d);
                    prev = d;
                }
            }
        }
        double t = 0;
        ListIterator iter = null;

        if (!operands.isEmpty()) {
            t = operands.getFirst();
            iter = operands.listIterator(1);
        }
        for (Character operator : operators) {
            double operand = (Double) iter.next();
            t = operator == '+' ? (t + operand) : (t - operand);
        }
        return t;
    }
}
