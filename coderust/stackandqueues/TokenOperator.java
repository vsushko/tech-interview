package stackandqueues;

public class TokenOperator implements Token {

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
        return mValue == '+' || mValue == '-' || mValue == '*' || mValue == '/';
    }
}
