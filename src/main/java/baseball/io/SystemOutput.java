package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class SystemOutput {

    public void begin() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void miss(int ball, int strike) {
        StringBuilder builder = new StringBuilder();

        if (ball > 0) {
            builder.append(ball + "볼");
        }
        if (strike > 0) {
            builder.append(" " + strike + "스트라이크");
        }
        System.out.println(builder.toString().trim());
    }

    public void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    
}
