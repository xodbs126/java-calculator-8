package calculator.domain.separator.strategy;

import calculator.dto.SplitStringDto;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPatternSeparator implements Separator {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    /***
     * 사용자 정의 구분자 전략 정의 로직
     * @param input 사용자 정의
     * @return 구분자 separator와 구분할 문자열 targetString이 담긴 Optional<SplitStringDto>
     */
    @Override
    public Optional<SplitStringDto> separateString(String input) {

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String targetString = matcher.group(2);
            return Optional.of(new SplitStringDto(customSeparator, targetString));
        }

        return Optional.empty();
    }
}
