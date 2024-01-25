package baseball.io;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String predict() throws IllegalArgumentException {
        String rawInput = Console.readLine().trim();
        if (rawInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
        try {
            Integer.parseInt(rawInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        return rawInput;
    }

    public String end() throws IllegalArgumentException {
        String rawInput = Console.readLine().trim();
        if (rawInput.equals("1") || rawInput.equals("2")) {
            return rawInput;
        }
        throw new IllegalArgumentException("1 혹은 2를 입력해야 합니다: " + rawInput);
    }
    
}
