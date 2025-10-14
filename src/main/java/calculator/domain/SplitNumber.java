package calculator.domain;

public class SplitNumber {

    private final SeparatorGenerator separatorGenerator;

    public SplitNumber(SeparatorGenerator separatorGenerator) {
        this.separatorGenerator = separatorGenerator;
    }

    public int[] splitNum(String stringInputs) {
        int[] splitedNum = separatorGenerator.separateString(stringInputs);

        return splitedNum;
    }
}
