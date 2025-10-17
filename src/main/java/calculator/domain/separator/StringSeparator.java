package calculator.domain.separator;

import calculator.domain.SeparatorGenerator;
import calculator.domain.validator.Validator;
import calculator.dto.SplitStringDto;

public class StringSeparator {

    private final SeparatorGenerator separatorGenerator;
    private final Validator<String> validator;

    public StringSeparator(SeparatorGenerator separatorGenerator, Validator validator) {
        this.separatorGenerator = separatorGenerator;
        this.validator = validator;
    }

    public String[] separate(String inputs) {
        SplitStringDto separatorAndTarget = separatorGenerator.separateString(inputs);
        String separator = separatorAndTarget.separator();
        validator.isValid(separator);
        String targetString = separatorAndTarget.targetString();

        return targetString.split(separator);
    }
}
