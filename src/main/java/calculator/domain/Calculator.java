package calculator.domain;

public class Calculator {

    private final SplitNumber splitNumber;

    public int add(String stringInputs) {
        int[] splitNum = splitNumber.splitNum(stringInputs);
        int sum = 0;

        for (int num : splitNum) {
            sum += num;
        }
        return sum;
    }

}
