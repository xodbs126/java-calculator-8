package calculator.domain.separator.strategy;

import calculator.dto.SplitStringDto;
import java.util.Optional;

public class DefaultSeparator implements Separator {

    private static final String DEFAULT_SEPARATOR = "[,:]";

    /***
     * 기본 구분자 전략 정의
     * @param input 사용자 입력
     * @return 구분자 separator와 구분할 문자열 targetString이 담긴 Optional<SplitStringDto>
     */
    @Override
    public Optional<SplitStringDto> separateString(String input) {
        return Optional.of(new SplitStringDto(DEFAULT_SEPARATOR, input));
    }
}
