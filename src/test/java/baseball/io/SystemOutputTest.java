package baseball.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SystemOutputTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("Test Begin")
    @Test
    public void testBegin() {
        // given
        SystemOutput output = new SystemOutput();

        // when
        output.begin();

        // then
        assertEquals("숫자를 입력해주세요 : ", outputStreamCaptor.toString());
    }

    @DisplayName("Test Miss")
    @Test
    public void testMiss() {
        // given
        SystemOutput output = new SystemOutput();
        // when
        output.miss(1, 0);
        output.miss(0, 1);
        output.miss(1, 1);
        output.miss(0, 0);
        // then
        assertEquals("1볼\n1스트라이크\n1볼 1스트라이크\n낫싱\n", outputStreamCaptor.toString());
    }
    @DisplayName("Test End")
    @Test
    public void testEnd() {
        // given
        SystemOutput output = new SystemOutput();

        // when
        output.end();

        // then
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", 
        outputStreamCaptor.toString());
    }
}
