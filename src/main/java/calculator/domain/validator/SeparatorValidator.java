package calculator.domain.validator;

public class SeparatorValidator implements Validator<String> {

    /***
     * 사용자 입력에 대한 분리자 유효성 검사
     * @param separator 사용자 입력에 따른 구분자
     * @return 구분자
     */
    @Override
    public String isValid(String separator) {
        if (separator.isEmpty()) {
            throw new IllegalArgumentException("연속된 구분자 입력은 허용하지 않습니다.");
        }

        return separator;
    }
}
