package baseball;

import baseball.io.SystemOutput;
import baseball.io.UserInput;
import baseball.rule.BaseballResult;
import baseball.rule.BaseballRule;

public class Application {
    public static void main(String[] args) {
        RandomDigit random = new RandomDigit();
        SystemOutput systemOutput = new SystemOutput();
        UserInput userInput = new UserInput();
        BaseballRule rule = new BaseballRule();
        boolean isContinue = true;

        while (isContinue) {
            String goal = random.generate(3);
            // System.out.println(goal);
            while (true) {
                systemOutput.begin();
                String input = userInput.predict();
                BaseballResult result = rule.check(input, goal);
                systemOutput.miss(result.getBall(), result.getStrike());
                if (result.getStrike() == 3) {
                    systemOutput.end();
                    String restartCheck = userInput.end();
                    isContinue = restartCheck.equals("1");
                    break;
                }
            }
        }
    }
}
