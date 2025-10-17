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

    private BigInteger parseToBigInteger(String stringNumber) {
        try {
            return new BigInteger(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값 중 숫자가 아닌 값이 있습니다: '" + stringNumber + "'");
        }
    }
}