package baseball.rule;

public class BaseballResult {
    private final int strike;
    private final int ball;

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
    
    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object obj) {
        BaseballResult target = (BaseballResult) obj;
        return (strike == target.strike && ball == target.ball);
    }
}
