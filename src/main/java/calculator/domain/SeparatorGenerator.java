package calculator.domain;

import calculator.dto.SplitStringDto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorGenerator {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public SplitStringDto separateString(String input) {
        if (input == null || input.isBlank()) {
            return new SplitStringDto(DEFAULT_SEPARATOR, "");
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String targetString = matcher.group(2);
            return new SplitStringDto(customSeparator, targetString);
        }

        return new SplitStringDto(DEFAULT_SEPARATOR, input);
    }
}