package calculator.domain.validator;

import java.math.BigInteger;

public class NumberRangeValidator implements Validator<BigInteger> {

    /***
     * 사용자 입력값에 대한 범위 Validator 정의
     * @param number 검증시도할 number
     * @return number
     */
    @Override
    public BigInteger isValid(BigInteger number) {
        if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 || number.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException(
                    "입력 범위를 벗어났습니다(1 ~ " + Integer.MAX_VALUE + ") 현재 입력: " + number);
        }

        return number;
    }
}
