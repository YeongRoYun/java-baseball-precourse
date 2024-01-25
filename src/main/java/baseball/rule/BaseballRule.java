package baseball.rule;

import java.util.*;

public class BaseballRule {

    public BaseballResult check(String input, String goal) {
        if (Objects.isNull(input) || Objects.isNull(goal) || input.length() != 3 || goal.length() != 3) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 3자리 숫자를 입력해주세요: goal: " + goal + "/input: " + input);
        }
        // input, goal 모두 3자리 숫자
        Set<Character> goalSet = new HashSet<>();
        for (char c : goal.toCharArray()) {
            goalSet.add(c);
        }

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; ++i) {
            
            if (input.charAt(i) == goal.charAt(i)) {
                strike += 1;
            } else if (goalSet.contains(input.charAt(i))) {
                ball += 1;
            }
        }
        return new BaseballResult(strike, ball);
    }

}
