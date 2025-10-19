package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class InputView {

    /***
     * 사용자의 입력 요청 및 안내 로직
     * @return 사용자의 String 입력값
     */
    public String input() throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }
}
