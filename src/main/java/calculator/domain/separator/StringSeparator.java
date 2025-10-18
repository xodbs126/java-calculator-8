package calculator.domain.separator;

import calculator.domain.separator.strategy.Separator;
import calculator.domain.validator.Validator;
import calculator.dto.SplitStringDto;
import java.util.List;
import java.util.Optional;

public class StringSeparator {

    private final List<Separator> separators;
    private final Validator<String> validator;

    public StringSeparator(List<Separator> separators, Validator<String> validator) {
        this.separators = separators;
        this.validator = validator;
    }

    public String[] separate(String inputs) {
        SplitStringDto separatorAndTarget = findFirstApplicableSeparator(inputs);

        String separator = separatorAndTarget.separator();
        validator.isValid(separator);
        String targetString = separatorAndTarget.targetString();
        return targetString.split(separator);
    }

    private SplitStringDto findFirstApplicableSeparator(String inputs) {
        return separators.stream()
                .map(separator -> separator.separateString(inputs))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("구분자 전략을 찾을 수 없습니다."));
    }
}