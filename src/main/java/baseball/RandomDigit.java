package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigit {

    public String generate(int count) {
        // List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, count);
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return numbers.stream().map(x -> String.valueOf(x)).reduce("", (acc, cur) -> acc + cur);
    }
}
