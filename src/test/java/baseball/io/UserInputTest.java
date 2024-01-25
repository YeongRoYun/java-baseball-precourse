package baseball.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    private final InputStream standardInput = System.in;

    @AfterEach
    public void tearDown() {
        System.setIn(standardInput);
    }

    @DisplayName("Test predict")
    @Test
    public void testPredictNormal() {
        // given
        UserInput input = new UserInput();
        
        // when
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        String predictedDigits = input.predict();

        // then
        assertEquals("123", predictedDigits);
    }

    @DisplayName("Test predict: exceptional case")
    @Test
    public void testPredictExceptional() {
        // given
        UserInput input = new UserInput();

        // when
        System.setIn(new ByteArrayInputStream("1234".getBytes()));
        // then
        assertThrows(IllegalArgumentException.class, () -> input.predict());
    }

    @DisplayName("Test end")
    @Test
    public void testEndNormal() {
        // given
        UserInput input = new UserInput();

        // when & then
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals("1", input.end());
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertEquals("2", input.end());
    }

    @DisplayName("Test end: exceptional case")
    @Test
    public void testEndExceptional() {
        // given
        UserInput input = new UserInput();

        // when & then
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThrows(IllegalArgumentException.class, () -> input.end());
    }
}
