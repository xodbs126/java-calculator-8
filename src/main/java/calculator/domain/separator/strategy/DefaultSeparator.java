package calculator.domain.separator.strategy;

import calculator.dto.SplitStringDto;
import java.util.Optional;

public class DefaultSeparator implements Separator {

    private static final String DEFAULT_SEPARATOR = "[,:]";

    @Override
    public Optional<SplitStringDto> separateString(String input) {
        return Optional.of(new SplitStringDto(DEFAULT_SEPARATOR, input));
    }
}
