package calculator.domain.parser;

import calculator.domain.separator.StringSeparator;
import calculator.domain.validator.Validator;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberParser {

    private final Validator<BigInteger> validator;
    private final StringSeparator stringSeparator;

    public NumberParser(Validator<BigInteger> validator, StringSeparator stringSeparator) {
        this.validator = validator;
        this.stringSeparator = stringSeparator;
    }

    /***
     * 사용자의 입력 값인 inputs을 StringSeparator를 통해 각 문자를 분리 후,
     * parseToBigInteger와 Validator을 통한 입력값을 검증 한다.
     * 그 후, 해당 값을 배열형태로 반환 (단, 빈 문자열일 경우, 0 반환)
     *
     * @param inputs 사용자의 입력 값
     * @return 사용자의 입력 값을 숫자로 변환 한 뒤 배열에 정의한 값
     */
    public int[] parseToInteger(String inputs) {
        String[] splitedString = stringSeparator.separate(inputs);

        if (inputs == null || inputs.isEmpty()) {
            return new int[0];
        }

        return Arrays.stream(splitedString)
                .map(this::parseToBigInteger)
                .map(validator::isValid)
                .mapToInt(BigInteger::intValue)
                .toArray();
    }

    /***
     * String 값을 BigInteger로 변환
     * NumberFormatException 발생 시, IllegalArgumentException
     *
     * @param stringNumber 구분자로 인해 분리된 사용자 입력 값
     * @return BigInteger로 형변환된 stringNumber
     */
    private BigInteger parseToBigInteger(String stringNumber) {
        try {
            return new BigInteger(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값 중 숫자가 아닌 값이 있습니다: '" + stringNumber + "'");
        }
    }
}