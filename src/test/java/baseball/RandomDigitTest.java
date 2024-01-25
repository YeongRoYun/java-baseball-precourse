package baseball;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomDigitTest {
    @DisplayName("Test Random n-digit")
    @Test
    public void testGenerateRandomDigits() {
        // given
        RandomDigit digit = new RandomDigit();
        
        // when
        String n1 = digit.generate(3);
        String n2 = digit.generate(3);

        // then
        assertTrue(n1.length() == 3 && n2.length() == 3);
        assertNotEquals(n1, n2);

        Set<Character> check = new HashSet<>();
        for (Character c: n1.toCharArray()) {
            assertFalse(check.contains(c));
            check.add(c);
        }
        check.clear();
        for (Character c: n2.toCharArray()) {
            assertFalse(check.contains(c));
            check.add(c);
        }
    }
}
