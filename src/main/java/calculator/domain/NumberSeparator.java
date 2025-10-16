package calculator.domain;

import calculator.dto.SplitStringDto;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberSeparator {

    private final SeparatorGenerator separatorGenerator;

    public NumberSeparator(SeparatorGenerator separatorGenerator) {
        this.separatorGenerator = separatorGenerator;
    }

    public int[] splitNum(String inputs) {
        String[] splitedString = splitString(inputs);

        if (inputs.isEmpty()) {
            return new int[0];
        }

        return Arrays.stream(splitedString)
                .mapToInt(this::parseValidNumber)
                .toArray();
    }

    private int parseValidNumber(String splitedString) {
        if (splitedString.isEmpty()) {
            throw new IllegalArgumentException("연속된 구분자 입력은 허용하지 않습니다.");
        }

        try {
            BigInteger number = new BigInteger(splitedString);

            if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0
                    || number.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                throw new IllegalArgumentException(
                        "입력 범위를 벗어났습니다(0 ~ " + Integer.MAX_VALUE + ") 현재 입력: " + splitedString);
            }

            if (number.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + splitedString);
            }

            return number.intValue();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다음과 같이 입력하세요."
                    + " \"\" => 0, \"1,2\" => 3, \"1,2,3\" => 6, //;\\n1;2;3 => 6 \""
                    + " 현재 입력: " + splitedString + "\"");
        }
    }

    private String[] splitString(String inputs) {
        SplitStringDto separatorAndTarget = separatorGenerator.separateString(inputs);
        String separator = separatorAndTarget.separator();
        String targetString = separatorAndTarget.targetString();

        String[] splitedString = targetString.split(separator);

        return splitedString;
    }


}
