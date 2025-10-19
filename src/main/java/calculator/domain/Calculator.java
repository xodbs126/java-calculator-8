package calculator.domain;

import calculator.domain.parser.NumberParser;

public class Calculator {

    private final NumberParser numberParser;

    public Calculator(NumberParser numberParser) {
        this.numberParser = numberParser;
    }

    /***
     *  구분자 규칙에 의해 사용자 String 입력값을 numberParser로 형변환 후,
     *  모든 수의 합을 반환해주는 로직
     * @param stringInputs 사용자에게 받은 입력 값
     * @return 형변환 후의 모든 수의 합
     */
    public int add(String stringInputs) {
        int sum = 0;
        int[] numberList = numberParser.parseToInteger(stringInputs);

        for (int num : numberList) {
            sum += num;
        }
        return sum;

    }
}