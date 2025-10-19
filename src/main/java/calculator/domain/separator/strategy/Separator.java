package calculator.domain.separator.strategy;

import calculator.dto.SplitStringDto;
import java.util.Optional;

public interface Separator {

    /***
     * 구분자 전략에 대한 인터페이스 구현
     * @param input
     * @return 구분자 separator와 구분할 문자열 targetString이 담긴 Optional<SplitStringDto>
     */
    Optional<SplitStringDto> separateString(String input);
}
