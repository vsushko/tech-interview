package stackandqueues;

import common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface Token {
    boolean isOperator();
}

/**
 * Given an arithmetic expression, evaluate it.
 * Solution #1
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Linear, O(n).
 */
public class ExpressionEvaluation {
}

class TokenOperator implements Token {

    private char mValue;

    public TokenOperator() {
        mValue = 0;
    }

    public TokenOperator(char mValue) {
        this.mValue = mValue;
    }

    public char getmValue() {
        return mValue;
    }

    public void setmValue(char mValue) {
        this.mValue = mValue;
    }

    @Override
    public boolean isOperator() {
        return false;
    }
}

class TokenOperand implements Token {

    private double mValue;

    public TokenOperand() {
        mValue = 0;
    }

    public TokenOperand(double mValue) {
        this.mValue = mValue;
    }

    public double getmValue() {
        return mValue;
    }

    public void setmValue(double mValue) {
        this.mValue = mValue;
    }

    @Override
    public boolean isOperator() {
        return false;
    }
}

class ExpressionEvaluation1 {

    static boolean isOperator(char temp) {
        return temp == '+' || temp == '-' || temp == '*' || temp == '/';
    }

    // returns true if op1 has higher/equal precedence compared to op2
    private static boolean preced(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return true;
        }

        if (op1 == '+' || op1 == '-') {
            if (op2 == '+' || op2 == '-') {
                return true;
            }
        }
        return false;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static Pair<Double, Integer> strToDouble(String s, int i) {
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

    static List<Token> convertToPostfix(String expr) {
        List<Token> postFix = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        int len = expr.length();
        for (int i = 0; i < len; ) {
            char ch = expr.charAt(i);
            if (ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }
            if (isOperator(ch)) {
                while (!operators.empty() && preced(operators.peek(), ch)) {
                    postFix.add(new TokenOperator(operators.peek()));
                    operators.pop();
                }
                operators.push(ch);
                ++i;
            } else {
                Pair<Double, Integer> p = strToDouble(expr, i);
                i = p.second;
                postFix.add(new TokenOperand(p.first));
            }
        }
        while (!operators.empty()) {
            postFix.add(new TokenOperator(operators.peek()));
            operators.pop();
        }
        return postFix;
    }

    public static double evaluate(List<Token> postFix) {
        Stack<Double> operands = new Stack<>();
        for (Token x : postFix) {
            if (x.isOperator()) {
                double val2 = operands.peek();
                operands.pop();
                double val1 = operands.peek();
                operands.pop();

                char op = ((TokenOperator) x).getmValue();
                if (op == '+') {
                    operands.push(val1 + val2);
                } else if (op == '-') {
                    operands.push(val1 - val2);
                } else if (op == '*') {
                    operands.push(val1 * val2);
                } else if (op == '/') {
                    operands.push(val1 / val2);
                }
            } else {
                double val = ((TokenOperand) x).getmValue();
                operands.push(val);
            }
        }
        if (operands.empty()) {
            return 0;
        }
        return operands.peek();
    }

    private static double evaluate(String expr) {
        return evaluate(convertToPostfix(expr));
    }
}