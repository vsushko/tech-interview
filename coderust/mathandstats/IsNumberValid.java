package mathandstats;

/**
 * Given an input string, determine if it makes a valid number or not.
 * <p>
 * Runtime Complexity: Linear, O(n).
 * Memory Complexity: Constant, O(1).
 */
public class IsNumberValid {

    public static void main(String[] args) {
        System.out.println("4.325: " + isNumberValid("4.325"));
        System.out.println("1.1.1: " + isNumberValid("1.1.1"));
        System.out.println("222: " + isNumberValid("222"));
        System.out.println("22.: " + isNumberValid("22."));
        System.out.println("22.22.: " + isNumberValid("22.22."));
    }

    private static STATE getNextState(STATE currentState, char ch) {
        switch (currentState) {
            case START:
            case INTEGER:
                if (ch == '.') {
                    return STATE.DECIMAL;
                } else if (ch >= '0' && ch <= '9') {
                    return STATE.INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }
            case DECIMAL:
                if (ch >= '0' && ch <= '9') {
                    return STATE.DECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
        }
        return STATE.UNKNOWN;
    }

    private static boolean isNumberValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }
        STATE currentState = STATE.START;

        while (i < s.length()) {
            currentState = getNextState(currentState, s.charAt(i));
            if (currentState == STATE.UNKNOWN) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }

    enum STATE {START, INTEGER, DECIMAL, UNKNOWN}
}
