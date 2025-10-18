package calculator.domain.separator.strategy;

import calculator.dto.SplitStringDto;
import java.util.Optional;

public interface Separator {

    Optional<SplitStringDto> separateString(String input);
}
