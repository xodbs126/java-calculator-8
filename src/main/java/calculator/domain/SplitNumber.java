package calculator.domain;

import calculator.dto.SplitStringDto;
import java.util.Arrays;

public class SplitNumber {

    private final SeparatorGenerator separatorGenerator;

    public SplitNumber(SeparatorGenerator separatorGenerator) {
        this.separatorGenerator = separatorGenerator;
    }

    public int[] splitNum(String inputs) {
        String[] splitedString = splitString(inputs);

        return Arrays.stream(splitedString)
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private String[] splitString(String inputs) {
        SplitStringDto separatorAndTarget = separatorGenerator.separateString(inputs);
        String separator = separatorAndTarget.separator();
        String targetString = separatorAndTarget.targetString();

        String[] splitedString = targetString.split(separator);

        return splitedString;
    }


}
