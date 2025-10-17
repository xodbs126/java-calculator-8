package calculator.domain.validator;

public class SeparatorValidator implements Validator<String> {

    @Override
    public String isValid(String separator) {
        if (separator.isEmpty()) {
            throw new IllegalArgumentException("연속된 구분자 입력은 허용하지 않습니다.");
        }

        return separator;
    }
}
