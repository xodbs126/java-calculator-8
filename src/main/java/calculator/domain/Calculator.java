package calculator.domain;

import calculator.domain.parser.NumberParser;

public class Calculator {

    private final NumberParser numberParser;

    public Calculator(NumberParser numberParser) {
        this.numberParser = numberParser;
    }

    public int add(String stringInputs) {
        int sum = 0;
        int[] numberList = numberParser.parseToInteger(stringInputs);

        for (int num : numberList) {
            sum += num;
        }
        return sum;

    }
}