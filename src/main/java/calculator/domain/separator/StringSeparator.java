package calculator.domain.separator;

import calculator.domain.separator.strategy.Separator;
import calculator.dto.SplitStringDto;
import java.util.List;
import java.util.Optional;

public class StringSeparator {

    private final List<Separator> separators;

    public StringSeparator(List<Separator> separators) {
        this.separators = separators;
    }

    /***
     * 사용자의 입력을 Separator를 통해 분리 후,
     * validator로 검증하는 로직
     *
     * @param inputs
     * @return  사용자의 입력을 separator로 구분한 String[]
     */
    public String[] separate(String inputs) {
        SplitStringDto separatorAndTarget = findFirstApplicableSeparator(inputs);

        String separator = separatorAndTarget.separator();
        String targetString = separatorAndTarget.targetString();
        return targetString.split(separator);
    }

    /***
     * 사용자의 입력을 분리 후, 구분자 전략을 적용시키는 로직
     *
     * @param inputs 사용자의 입력
     * @return 구분자 separator와 구분할 문자열 targetString이 담긴 Optional<SplitStringDto>
     */
    private SplitStringDto findFirstApplicableSeparator(String inputs) {
        return separators.stream()
                .map(separator -> separator.separateString(inputs))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("구분자 전략을 찾을 수 없습니다."));
    }
}