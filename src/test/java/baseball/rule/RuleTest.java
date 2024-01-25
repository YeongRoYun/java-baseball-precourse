package baseball.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RuleTest {

    @DisplayName("Test Rule")
    @Test
    public void testRule() {
        // given
        BaseballRule rule = new BaseballRule();
        String goal = "123";
        String input = "123";
        BaseballResult expected = new BaseballResult(3, 0);
        // when
        BaseballResult result = rule.check(input, goal);

        // then
        assertEquals(expected, result);
    }
    
}
