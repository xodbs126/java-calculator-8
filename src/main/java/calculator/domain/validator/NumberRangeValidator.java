package calculator.domain.validator;

import java.math.BigInteger;

public class NumberRangeValidator implements Validator<BigInteger> {

    @Override
    public BigInteger isValid(BigInteger number) {
        if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 || number.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException(
                    "입력 범위를 벗어났습니다(1 ~ " + Integer.MAX_VALUE + ") 현재 입력: " + number);
        }

        return number;
    }
}
