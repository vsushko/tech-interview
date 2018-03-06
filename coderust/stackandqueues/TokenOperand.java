package stackandqueues;

public class TokenOperand implements Token {

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
